package main.data.readers;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Key : word
// Value : root
public class LemmasReader extends GenericReader<Map<String, String>> {
	private static final Logger logger = LoggerFactory.getLogger(LemmasReader.class);

	public LemmasReader() {
		super(GenericLineReaderUtil.readAndProcess("/data/reference_lemmas.txt", (lines) -> {
			Map<String, String> lemmas = new TreeMap<>();

            lines.forEach(line -> {
            	String[] items = line.split("\t");
            	String word = items[0].trim();
            	String root = items[1].trim();
            	logger.debug("word :'" + word + "', root:'" + root + "'");
            	lemmas.put(word, root);
            });
            return lemmas;
		}));
		//		lemmas.put("vue", "vue"); 
		//		lemmas.put("ils", "ils");
		//		lemmas.put("liste", "liste");
		//		lemmas.put("veux", "veux");
		//		lemmas.put("reste", "reste");
		//		lemmas.put("peste", "peste");
		//		lemmas.put("piste", "piste");
	}
}
