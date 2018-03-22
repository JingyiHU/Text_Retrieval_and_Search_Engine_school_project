package main.data.readers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.tokenizer.TokenConstant;

// word to metadata
public class TokensReader extends GenericReader<Map<String, TokenConstant>> {
	private static final Logger logger = LoggerFactory.getLogger(TokensReader.class);

	public TokensReader() {
		super(GenericLineReaderUtil.readAndProcess("/data/tokens.txt", (lines) -> {
			Map<String, TokenConstant> tokens = new HashMap<>();
			lines.forEach(line -> {
            	String[] splitLine = line.trim().split(" ");
            	String word = splitLine[0];
            	String tokenConstant = splitLine[1];
            	logger.debug("word : '" + word + "', tokenConstant : '" + tokenConstant + "'");

				tokens.put(word, TokenConstant.valueOf(tokenConstant));
            });
			
			return tokens;
		}));
	}
}
