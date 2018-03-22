package main.spelling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

import main.spelling.data.Matrix;

public class CustomLevenshtein {
	// Custom levenshtein
	// Added a discrimination score to compensate for permutations
	public static double levenshteinCompare(String w1, String w2) {
		int l1 = w1.length();
		int l2 = w2.length();
		Matrix d = new Matrix(l1 + 1, l2 + 1);
		
		for (int i = 0; i <= l1; i++) {
			d.set(i, 0, i);
		}

		for (int j = 0; j <= l2; j++) {
			d.set(0, j, j);
		}
		
		for (int j = 1; j <= l2; j++) {
			for (int i = 1; i <= l1; i++) {
				int substitutionCost = 1;
				if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
					substitutionCost = 0;
				}
				d.set(
						i,
						j,
						min(
								d.get(i - 1, j) + 1,
								d.get(i, j - 1) + 1,
								d.get(i - 1, j - 1) + substitutionCost
						)
				);
			}
		}
		
		// d.print();
		double discriminationScore = discriminationScore(w1, w2);
		Integer levenshteinScore = d.get(l1, l2);
		double total = levenshteinScore + discriminationScore;
//		logger.debug("w1: " + w1 + ", w2: " + w2 + ", discriminationScore: " + discriminationScore +
//				", levenshteinPart:" + levenshteinScore + ", total:" + total);
		
		return total;
	}
	
	public static double discriminationScore(String w1, String w2) {
		List<Integer> v1 = new ArrayList<>();
		List<Integer> v2 = new ArrayList<>();
		
		Set<Integer> chars = new HashSet<>();
		w1.chars().forEach(c -> chars.add(c));
		w2.chars().forEach(c -> chars.add(c));
		
		List<Integer> listChars = Lists.newArrayList(chars);
		listChars.forEach(c -> {
			v1.add(0);
			v2.add(0);
		});
		
		w1.chars().forEach(c -> {
			int i = listChars.indexOf(c);
			v1.set(i, v1.get(i) + 1);
		});
		w2.chars().forEach(c -> {
			int i = listChars.indexOf(c);
			v2.set(i, v2.get(i) + 1);
		});
		
		List<Integer> v1Minusv2 = new ArrayList<>();
		for (int i = 0; i < v1.size(); i++) {
			v1Minusv2.add(0);
		}
		
		double norm = 0.0;
		for (int i = 0; i < v1.size(); i++) {
			int r = v1.get(i) - v2.get(i);
			v1Minusv2.set(i, r);
			
			norm += r*r;
		}
		norm = Math.sqrt(norm);
		
//		logger.debug(v1 + "");
//		logger.debug(v2 + "");
//		logger.debug(v1Minusv2 + "");
		
		return norm;
	}
	
	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}
