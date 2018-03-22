package main.tokenizer;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.data.readers.StoplistReader;

public class Stoplist {
	private static final Logger logger = LoggerFactory.getLogger(Stoplist.class);
	private Set<String> stoplist;
	
	public Stoplist() {
		stoplist = new StoplistReader().getData();
	}

	public boolean isInStoplist(String s) {
		if (s.length() < 2) {
			return true;
		}

		return stoplist.contains(s);
	}
}
