package main.spelling;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import main.repl.GenericREPL;

public class SpellingREPL {
	private static final Logger logger = LoggerFactory.getLogger(SpellingREPL.class);

	public static void main(String[] args) {
		Lemmatizer lemme = new Lemmatizer();

		GenericREPL.start((input) -> {
			logger.info(Lists.newArrayList(input.split(" "))
				.stream()
				.map(word -> lemme.getLemme(word).stream().collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"))
			);
		});
//		lemme.levenshteinCompare("oslo", "snow");
	}
}
