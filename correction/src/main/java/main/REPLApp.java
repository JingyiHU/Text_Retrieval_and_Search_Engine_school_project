package main;

import main.repl.GenericREPL;

public class REPLApp {
	public static void main(String[] args) {
		GenericREPL.start((input) -> {
			InputHandler.handleInput(input);
		});
	}
}
