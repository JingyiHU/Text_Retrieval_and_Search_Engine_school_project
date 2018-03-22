package main.spelling;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

import main.data.readers.LemmasReader;
import main.spelling.data.WordWithProximity;

public class Lemmatizer {
	private static final Logger logger = LoggerFactory.getLogger(Lemmatizer.class);
	private final Map<String, String> lemme;
	
	public Lemmatizer() {
		this.lemme = new LemmasReader().getData();
	}
	
	public List<String> getLemme(String word) {
		String normalizedWord = normalizeString(word);

		String lemme = directGetLemme(normalizedWord);
		if (lemme != null) {
			logger.debug("Using direct get");
			return ImmutableList.of(lemme);
		}

		List<String> lemmes = null;
		lemmes = closestGetLemme(normalizedWord);
		if (lemmes != null) {
			logger.debug("Using closest get");
			return lemmes;
		}

		lemmes = levenshteinGetLemme(normalizedWord);
		if (lemmes != null) {
			logger.debug("Using levenshtein get");
			return lemmes;
		}
		
		return lemmes;
	}
	
	private String normalizeString(String word) {
		return word.toLowerCase();
	}

	private String directGetLemme(String word) {
		return lemme.get(word);
	}
	
	private List<String> closestGetLemme(String word) {
		List<WordWithProximity> results = lemme
				.keySet()
				.stream()
				.map(currentWord -> {
					return new WordWithProximity(lemme.get(currentWord), proximity(currentWord, word));
				})
				.filter(lemmeWithProximity -> {
					return lemmeWithProximity.getProximity() != 0;
				})
				.sorted(Comparator.comparing(WordWithProximity::getProximity).reversed())
				.collect(Collectors.toList());
		WordWithProximity result = results.isEmpty() ? null : results.get(0);
		if (result != null) {
			logger.debug("Closests with distance : " + result.getProximity());
			return results
					.stream()
					.filter(r -> r.getProximity() == result.getProximity())
					.map(r -> r.getWord())
					.collect(Collectors.toList());
		}
		return null;
	}
	
	private double proximity(String w1, String w2) {
//		logger.debug("w1 :" + w1 + ", w2 :" + w2);
		int l1 = w1.length();
		int l2 = w2.length();
		int minCommonLettersLimit = 4; // 4
		int minLengthLimit = 3; // 3
		int maxLengthDeltaLimit = 4;
		
//		logger.debug("w1 : " + w1 + ", w2 : " + w2);
//		logger.debug("l1 : " + l1 + ", l2 : " + l2);
		if (l1 < minLengthLimit || l2 < minLengthLimit) {
			return 0;
		}
		if (Math.abs(l1 - l2) > 4) {
			return 0;
		}
		
		int i = 0;
		int minLength = Math.min(l1, l2);
		while (i < minLength && w1.charAt(i) == w2.charAt(i)) {
			i++;
		}
//		logger.debug("i : " + i);
		if (i <= minCommonLettersLimit) {
			return 0;
		}
		
		return (i / (Math.max(l1, l2) * 1.0)) * 100;
	}
	
	private List<String> levenshteinGetLemme(String word) {
		List<WordWithProximity> results = lemme
				.keySet()
				.stream()
				.map(r -> new WordWithProximity(lemme.get(r), CustomLevenshtein.levenshteinCompare(r, word)))
				.sorted((w1, w2) -> Double.compare(w1.getProximity(), w2.getProximity()))
				.collect(Collectors.toList());
		WordWithProximity result = results.isEmpty() ? null : results.get(0);
		
		if (result != null) {
			logger.debug("Main selection levenshtein distance : " + result.getProximity());
			if (result.getProximity() > 5) {
				logger.debug("Distance too high, result ignored");
				return null;
			}
			return results
					.stream()
					.filter(r -> r.getProximity() == result.getProximity())
					.map(r -> r.getWord())
					.collect(Collectors.toList());
		}

		return null;
	}	
}
