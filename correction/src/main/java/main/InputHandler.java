package main;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import main.db.PostgresExecutor;
import main.sql.TalMain3;
import main.sql.data.Arbre;
import main.sql.lib.BasicFormatterImpl;
import main.tokenizer.Stoplist;
import main.tokenizer.TokenConstant;
import main.tokenizer.TokenFactory;
import main.tokenizer.data.Token;
import main.tokenizer.data.TokenType;

public class InputHandler {
	private static Logger logger = LoggerFactory.getLogger(InputHandler.class);
	private static final Stoplist stoplist = new Stoplist();

	public static QueryResult handleInput(String input) {
		Arbre arbre = processInput(input).getFils();
		String query = arbre.sortArbre();

		String columns = arbre.getStringData("columns");
		Integer columnCount = columns.split(",").length;
		Integer paramCount = arbre.getIntegerData("param_count");
		Boolean intersection = arbre.getBooleanData("intersection");
		
		if (!Strings.isNullOrEmpty(columns)) {
			if (Boolean.TRUE.equals(intersection)) {
				query = query + "group by " + columns + " having count(distinct mot) >= " + paramCount;
			} else {
				query = query + "group by " + columns;
			}
		}
		
		query = query + " order by count(mot) desc";
		query = query + " limit 10";
		
		
		logger.info("query : " + query);
		logger.info("columns : " + columns);
		logger.info("column_count : " + columnCount);
		logger.info("param_count : " + paramCount);
		logger.info("intersection : " + intersection);

		return new QueryResult(PostgresExecutor.executeSelect(query), new BasicFormatterImpl().format(query));
	}

	public static Arbre processInput(String input) {
		List<String> words = splitNormalizeInput(input);

		List<Token> tokens = wordsToTokens(words);
		
		List<Token> list = tokens;
			
		printTokens(list);

		list = list
			.stream()
			.filter(s -> s.getType() != TokenType.WORD || !stoplist.isInStoplist(s.getToken()))
			.collect(Collectors.toList());
		
		if (list.get(list.size() - 1).getType() == TokenType.CONJUNCTION) {
			list.remove(list.get(list.size() - 1));
		}
		
		printTokens(list);
		
		String requestType = extractStructuredToken(list, TokenType.REQUEST_TYPE, TokenConstant.SELECT);
		String requestItems = extractStructuredToken(list, TokenType.REQUEST_ITEMS, TokenConstant.FICHIER);
		
		String requestTable = extractStructuredToken(list, TokenType.REQUEST_TABLE, TokenConstant.TEXTE);
		if (requestItems.equals(TokenConstant.DATE.name())) {
			requestTable = TokenConstant.DATE.name();
		}

		String result = ImmutableList.of(requestType, requestItems, requestTable).stream().collect(Collectors.joining(" ")) + " " +
				list
					.stream()
					.filter(t -> ImmutableList.of(TokenType.WORD, TokenType.CONJUNCTION, TokenType.SPECIAL).contains(t.getType()))
					.map(t -> t.getToken())
					.collect(Collectors.joining(" "));
		
		print(result);
		
		Long paramCount = list.stream().filter(t -> t.getType() == TokenType.WORD).count();
		
		return TalMain3.toSql(result + ".");
	}

	private static void printTokens(List<Token> list) {
		logger.info(list.stream().map(t -> t.toString()).collect(Collectors.joining(" ")));
	}

	private static String extractStructuredToken(List<Token> list, TokenType tokenType, TokenConstant defaultValue) {
		if (tokenType.equals(TokenType.REQUEST_ITEMS)) {
			Token tok = list
					.stream()
					.filter(t -> t.getType() == TokenType.REQUEST_ITEMS && t.getToken().equals(TokenConstant.DATE.name()))
					.findFirst()
					.orElse(null);
			if (tok != null) {
				return tok.getToken();
			}
		}

		return list
			.stream()
			.filter(t -> t.getType() == tokenType)
			.map(t -> t.getToken())
			.findFirst()
			.orElse(defaultValue.name());
	}

	private static List<Token> wordsToTokens(List<String> words) {
		return words
				.stream()
				.filter(word -> !stoplist.isInStoplist(word))
				.map(w -> TokenFactory.create(w))
				.collect(Collectors.toList());
	}

	private static List<String> splitNormalizeInput(String input) {
		String processedString = input.toLowerCase().replaceAll("['`*$^!:;,?./§µ£=)}{|#~'(_’\\-\"]", " ");
		
		print("processedString : " + processedString);

		return Lists.newArrayList(processedString.split(" "))
					.stream()
					.collect(Collectors.toList());
	}
		
	private static void print(String s) {
		logger.info(s);
	}
}
