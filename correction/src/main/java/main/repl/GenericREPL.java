package main.repl;

import java.util.Scanner;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericREPL {
	private static final Logger logger = LoggerFactory.getLogger(GenericREPL.class);

	public static void start(Consumer<String> consumer) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				logger.info("User input :\n");
				String input = scanner.nextLine();

				try {
					consumer.accept(input);
				} catch (Throwable t) {
					logger.error("An error has occured :", t);
				}
			}
		}
	}

}
