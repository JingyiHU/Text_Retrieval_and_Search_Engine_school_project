package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import main.tokenizer.Stoplist;

public class AppTest {
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	public static void main(String[] argv) {
		Logger LOG = LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
		((ch.qos.logback.classic.Logger) LOG).setLevel(Level.INFO);

		try {
            Stream <String> lines = Files.lines(
            		Paths.get(Stoplist.class.getResource("/requetes_test.txt").toURI())
			);
            lines.forEach(line -> {
            	String sentence = line.trim();
            	logger.info("Testing sentence '" + sentence + "'");
            	InputHandler.processInput(sentence);
            });
            lines.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
