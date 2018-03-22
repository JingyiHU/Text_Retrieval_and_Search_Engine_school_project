package main.db;

import main.repl.GenericREPL;

public class DbREPL {
	public static void main(String[] args) {
		GenericREPL.start((input) -> {
//			String query = "select distinct fichier,rubrique from titretexte where mot='micro';";
			String query = input;
			PostgresExecutor.executeSelect(query);
		});
	}

}
