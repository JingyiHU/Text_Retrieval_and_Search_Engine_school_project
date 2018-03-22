package main.data.readers;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoplistReader extends GenericReader<Set<String>> {
	private static final Logger logger = LoggerFactory.getLogger(StoplistReader.class);

	public StoplistReader() {
		super(GenericLineReaderUtil.readAndProcess("/data/stoplist.txt", (lines) -> {
			Set<String> stoplist = new HashSet<>();
            lines.forEach(line -> {
            	String word = line.trim();
            	logger.debug("word :'" + word + "'");
            	stoplist.add(word);
            });
            
            return stoplist;
		}));
	}
}
