package main.sql;

import java.io.StringReader;
import java.util.Scanner;

//import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;

import main.sql.data.Arbre;
import main.sql.output.Tal_sqlLexer;
import main.sql.output.Tal_sqlParser;


public class TalMain3 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Texte : ");
		String s = scanner.nextLine();
		System.out.println(s);
		while (!s.equals("*")) {
			toSql(s);
			System.out.print("Texte : ");
			s = scanner.nextLine();
		}
	}

	public static Arbre toSql(String s) {
		try{
			Tal_sqlLexer lexer = new Tal_sqlLexer(new ANTLRReaderStream(new StringReader(s)));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			Tal_sqlParser parser = new Tal_sqlParser(tokens);
			Arbre arbre = parser.listerequetes();

			return arbre;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
