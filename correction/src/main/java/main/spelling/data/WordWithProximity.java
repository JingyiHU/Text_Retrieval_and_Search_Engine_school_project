package main.spelling.data;

public class WordWithProximity {
	private String word;
	private double proximity;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getProximity() {
		return proximity;
	}

	public void setProximity(double proximity) {
		this.proximity = proximity;
	}

	public WordWithProximity(String word, double proximity) {
		this.word = word;
		this.proximity = proximity;
	}
}
