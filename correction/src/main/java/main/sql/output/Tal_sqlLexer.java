// $ANTLR 3.5.1 /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g 2017-12-19 01:51:49

    package main.sql.output;
    import main.sql.data.Arbre;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Tal_sqlLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ANNEE=4;
	public static final int CHAR=5;
	public static final int COUNT=6;
	public static final int DATE=7;
	public static final int ENTRE=8;
	public static final int ET=9;
	public static final int FICHIER=10;
	public static final int JOUR=11;
	public static final int MOIS=12;
	public static final int NOMBRE=13;
	public static final int NUMERO=14;
	public static final int OU=15;
	public static final int POINT=16;
	public static final int SELECT=17;
	public static final int TEXTE=18;
	public static final int VAR=19;
	public static final int WS=20;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public Tal_sqlLexer() {} 
	public Tal_sqlLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public Tal_sqlLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g"; }

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:15:8: ( 'SELECT' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:15:10: 'SELECT'
			{
			match("SELECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "COUNT"
	public final void mCOUNT() throws RecognitionException {
		try {
			int _type = COUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:18:8: ( 'COUNT' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:18:10: 'COUNT'
			{
			match("COUNT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COUNT"

	// $ANTLR start "FICHIER"
	public final void mFICHIER() throws RecognitionException {
		try {
			int _type = FICHIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:21:9: ( 'FICHIER' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:21:11: 'FICHIER'
			{
			match("FICHIER"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FICHIER"

	// $ANTLR start "NUMERO"
	public final void mNUMERO() throws RecognitionException {
		try {
			int _type = NUMERO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:24:8: ( 'NUMERO' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:24:10: 'NUMERO'
			{
			match("NUMERO"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMERO"

	// $ANTLR start "NOMBRE"
	public final void mNOMBRE() throws RecognitionException {
		try {
			int _type = NOMBRE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:27:8: ( 'NOMBRE' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:27:10: 'NOMBRE'
			{
			match("NOMBRE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOMBRE"

	// $ANTLR start "ENTRE"
	public final void mENTRE() throws RecognitionException {
		try {
			int _type = ENTRE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:30:7: ( 'ENTRE' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:30:9: 'ENTRE'
			{
			match("ENTRE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENTRE"

	// $ANTLR start "MOIS"
	public final void mMOIS() throws RecognitionException {
		try {
			int _type = MOIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:6: ( 'JANVIER' | 'FEVRIER' | 'MARS' | 'AVRIL' | 'MAI' | 'JUIN' | 'JUILLET' | 'AOUT' | 'SEPTEMBRE' | 'OCTOBRE' | 'NOVEMBRE' | 'DECEMBRE' )
			int alt1=12;
			switch ( input.LA(1) ) {
			case 'J':
				{
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='A') ) {
					alt1=1;
				}
				else if ( (LA1_1=='U') ) {
					int LA1_10 = input.LA(3);
					if ( (LA1_10=='I') ) {
						int LA1_14 = input.LA(4);
						if ( (LA1_14=='N') ) {
							alt1=6;
						}
						else if ( (LA1_14=='L') ) {
							alt1=7;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 14, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 10, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'F':
				{
				alt1=2;
				}
				break;
			case 'M':
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3=='A') ) {
					int LA1_11 = input.LA(3);
					if ( (LA1_11=='R') ) {
						alt1=3;
					}
					else if ( (LA1_11=='I') ) {
						alt1=5;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 11, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'A':
				{
				int LA1_4 = input.LA(2);
				if ( (LA1_4=='V') ) {
					alt1=4;
				}
				else if ( (LA1_4=='O') ) {
					alt1=8;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'S':
				{
				alt1=9;
				}
				break;
			case 'O':
				{
				alt1=10;
				}
				break;
			case 'N':
				{
				alt1=11;
				}
				break;
			case 'D':
				{
				alt1=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:8: 'JANVIER'
					{
					match("JANVIER"); 

					}
					break;
				case 2 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:20: 'FEVRIER'
					{
					match("FEVRIER"); 

					}
					break;
				case 3 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:32: 'MARS'
					{
					match("MARS"); 

					}
					break;
				case 4 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:41: 'AVRIL'
					{
					match("AVRIL"); 

					}
					break;
				case 5 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:51: 'MAI'
					{
					match("MAI"); 

					}
					break;
				case 6 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:31:59: 'JUIN'
					{
					match("JUIN"); 

					}
					break;
				case 7 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:1: 'JUILLET'
					{
					match("JUILLET"); 

					}
					break;
				case 8 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:13: 'AOUT'
					{
					match("AOUT"); 

					}
					break;
				case 9 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:22: 'SEPTEMBRE'
					{
					match("SEPTEMBRE"); 

					}
					break;
				case 10 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:36: 'OCTOBRE'
					{
					match("OCTOBRE"); 

					}
					break;
				case 11 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:48: 'NOVEMBRE'
					{
					match("NOVEMBRE"); 

					}
					break;
				case 12 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:32:61: 'DECEMBRE'
					{
					match("DECEMBRE"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOIS"

	// $ANTLR start "ANNEE"
	public final void mANNEE() throws RecognitionException {
		try {
			int _type = ANNEE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:33:8: ( ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:33:10: ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' ) ( '0' .. '9' )
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANNEE"

	// $ANTLR start "JOUR"
	public final void mJOUR() throws RecognitionException {
		try {
			int _type = JOUR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:34:7: ( ( '0' .. '9' ) ( '0' .. '9' )? )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:34:9: ( '0' .. '9' ) ( '0' .. '9' )?
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:34:19: ( '0' .. '9' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOUR"

	// $ANTLR start "ET"
	public final void mET() throws RecognitionException {
		try {
			int _type = ET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:36:4: ( 'ET' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:36:7: 'ET'
			{
			match("ET"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ET"

	// $ANTLR start "OU"
	public final void mOU() throws RecognitionException {
		try {
			int _type = OU;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:37:5: ( 'OU' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:37:7: 'OU'
			{
			match("OU"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OU"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			int _type = POINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:39:7: ( '.' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:39:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POINT"

	// $ANTLR start "TEXTE"
	public final void mTEXTE() throws RecognitionException {
		try {
			int _type = TEXTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:42:7: ( 'TEXTE' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:42:9: 'TEXTE'
			{
			match("TEXTE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEXTE"

	// $ANTLR start "DATE"
	public final void mDATE() throws RecognitionException {
		try {
			int _type = DATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:45:6: ( 'DATE' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:45:8: 'DATE'
			{
			match("DATE"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATE"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:48:7: ( 'Â' .. 'ü' | 'a' .. 'z' | 'A' .. 'Z' )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C2' && input.LA(1) <= '\u00FC') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:51:6: ( ( CHAR | '0' .. '9' )+ )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:51:8: ( CHAR | '0' .. '9' )+
			{
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:51:8: ( CHAR | '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')||(LA3_0 >= '\u00C2' && LA3_0 <= '\u00FC')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C2' && input.LA(1) <= '\u00FC') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:54:5: ( ( ' ' | '\\t' | '\\r' ) | '\\n' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\t'||LA4_0=='\r'||LA4_0==' ') ) {
				alt4=1;
			}
			else if ( (LA4_0=='\n') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:54:7: ( ' ' | '\\t' | '\\r' )
					{
					if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					skip();
					}
					break;
				case 2 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:54:38: '\\n'
					{
					match('\n'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:8: ( SELECT | COUNT | FICHIER | NUMERO | NOMBRE | ENTRE | MOIS | ANNEE | JOUR | ET | OU | POINT | TEXTE | DATE | CHAR | VAR | WS )
		int alt5=17;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:10: SELECT
				{
				mSELECT(); 

				}
				break;
			case 2 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:17: COUNT
				{
				mCOUNT(); 

				}
				break;
			case 3 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:23: FICHIER
				{
				mFICHIER(); 

				}
				break;
			case 4 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:31: NUMERO
				{
				mNUMERO(); 

				}
				break;
			case 5 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:38: NOMBRE
				{
				mNOMBRE(); 

				}
				break;
			case 6 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:45: ENTRE
				{
				mENTRE(); 

				}
				break;
			case 7 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:51: MOIS
				{
				mMOIS(); 

				}
				break;
			case 8 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:56: ANNEE
				{
				mANNEE(); 

				}
				break;
			case 9 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:62: JOUR
				{
				mJOUR(); 

				}
				break;
			case 10 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:67: ET
				{
				mET(); 

				}
				break;
			case 11 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:70: OU
				{
				mOU(); 

				}
				break;
			case 12 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:73: POINT
				{
				mPOINT(); 

				}
				break;
			case 13 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:79: TEXTE
				{
				mTEXTE(); 

				}
				break;
			case 14 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:85: DATE
				{
				mDATE(); 

				}
				break;
			case 15 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:90: CHAR
				{
				mCHAR(); 

				}
				break;
			case 16 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:95: VAR
				{
				mVAR(); 

				}
				break;
			case 17 :
				// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:1:99: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\12\21\1\44\1\uffff\2\21\1\uffff\1\22\2\uffff\6\22\1\57\6\22\1"+
		"\67\2\22\1\44\1\uffff\12\22\1\uffff\3\22\1\111\3\22\1\uffff\16\22\1\111"+
		"\1\22\1\111\1\uffff\1\22\1\111\2\22\1\137\1\140\3\22\1\144\5\22\1\152"+
		"\2\22\1\111\2\22\2\uffff\1\157\1\160\1\22\1\uffff\2\22\1\164\1\165\1\22"+
		"\1\uffff\4\22\2\uffff\1\22\1\174\1\111\2\uffff\1\22\3\111\2\22\1\uffff"+
		"\3\111";
	static final String DFA5_eofS =
		"\u0080\uffff";
	static final String DFA5_minS =
		"\1\11\13\60\1\uffff\2\60\1\uffff\1\114\2\uffff\1\125\1\103\1\126\2\115"+
		"\1\124\1\60\1\116\2\111\1\122\1\125\1\124\1\60\1\103\1\124\1\60\1\uffff"+
		"\1\130\1\105\1\124\1\116\1\110\1\122\1\105\1\102\1\105\1\122\1\uffff\1"+
		"\126\1\114\1\123\1\60\1\111\1\124\1\117\1\uffff\2\105\1\60\1\124\1\103"+
		"\1\105\1\124\2\111\2\122\1\115\1\105\1\111\1\60\1\114\1\60\1\uffff\1\114"+
		"\1\60\1\102\1\115\2\60\1\105\1\124\1\115\1\60\2\105\1\117\1\105\1\102"+
		"\1\60\2\105\1\60\1\122\1\102\2\uffff\2\60\1\102\1\uffff\2\122\2\60\1\122"+
		"\1\uffff\1\122\1\124\1\105\1\122\2\uffff\1\122\2\60\2\uffff\1\105\3\60"+
		"\2\105\1\uffff\3\60";
	static final String DFA5_maxS =
		"\14\u00fc\1\uffff\2\u00fc\1\uffff\1\120\2\uffff\1\125\1\103\1\126\1\115"+
		"\1\126\1\124\1\u00fc\1\116\1\111\2\122\1\125\1\124\1\u00fc\1\103\1\124"+
		"\1\u00fc\1\uffff\1\130\1\105\1\124\1\116\1\110\1\122\1\105\1\102\1\105"+
		"\1\122\1\uffff\1\126\1\116\1\123\1\u00fc\1\111\1\124\1\117\1\uffff\2\105"+
		"\1\71\1\124\1\103\1\105\1\124\2\111\2\122\1\115\1\105\1\111\1\u00fc\1"+
		"\114\1\u00fc\1\uffff\1\114\1\u00fc\1\102\1\115\2\u00fc\1\105\1\124\1\115"+
		"\1\u00fc\2\105\1\117\1\105\1\102\1\u00fc\2\105\1\u00fc\1\122\1\102\2\uffff"+
		"\2\u00fc\1\102\1\uffff\2\122\2\u00fc\1\122\1\uffff\1\122\1\124\1\105\1"+
		"\122\2\uffff\1\122\2\u00fc\2\uffff\1\105\3\u00fc\2\105\1\uffff\3\u00fc";
	static final String DFA5_acceptS =
		"\14\uffff\1\14\2\uffff\1\21\1\uffff\1\17\1\20\21\uffff\1\11\12\uffff\1"+
		"\12\7\uffff\1\13\21\uffff\1\7\25\uffff\1\16\1\10\3\uffff\1\2\5\uffff\1"+
		"\6\4\uffff\1\15\1\1\3\uffff\1\4\1\5\6\uffff\1\3\3\uffff";
	static final String DFA5_specialS =
		"\u0080\uffff}>";
	static final String[] DFA5_transitionS = {
			"\2\17\2\uffff\1\17\22\uffff\1\17\15\uffff\1\14\1\uffff\12\13\7\uffff"+
			"\1\10\1\16\1\2\1\12\1\5\1\3\3\16\1\6\2\16\1\7\1\4\1\11\3\16\1\1\1\15"+
			"\6\16\6\uffff\32\16\107\uffff\73\16",
			"\12\22\7\uffff\4\22\1\20\25\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\16\22\1\23\13\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\4\22\1\25\3\22\1\24\21\22\6\uffff\32\22\107\uffff\73"+
			"\22",
			"\12\22\7\uffff\16\22\1\27\5\22\1\26\5\22\6\uffff\32\22\107\uffff\73"+
			"\22",
			"\12\22\7\uffff\15\22\1\30\5\22\1\31\6\22\6\uffff\32\22\107\uffff\73"+
			"\22",
			"\12\22\7\uffff\1\32\23\22\1\33\5\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\1\34\31\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\16\22\1\36\6\22\1\35\4\22\6\uffff\32\22\107\uffff\73"+
			"\22",
			"\12\22\7\uffff\2\22\1\37\21\22\1\40\5\22\6\uffff\32\22\107\uffff\73"+
			"\22",
			"\12\22\7\uffff\1\42\3\22\1\41\25\22\6\uffff\32\22\107\uffff\73\22",
			"\12\43\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"",
			"\12\22\7\uffff\4\22\1\45\25\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"",
			"\1\46\3\uffff\1\47",
			"",
			"",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54\10\uffff\1\55",
			"\1\56",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\60",
			"\1\61",
			"\1\63\10\uffff\1\62",
			"\1\64",
			"\1\65",
			"\1\66",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\70",
			"\1\71",
			"\12\72\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"",
			"\1\105",
			"\1\107\1\uffff\1\106",
			"\1\110",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\112",
			"\1\113",
			"\1\114",
			"",
			"\1\115",
			"\1\116",
			"\12\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\133",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"",
			"\1\134",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\135",
			"\1\136",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\141",
			"\1\142",
			"\1\143",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\153",
			"\1\154",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\155",
			"\1\156",
			"",
			"",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\161",
			"",
			"\1\162",
			"\1\163",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\166",
			"",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"",
			"",
			"\1\173",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"",
			"",
			"\1\175",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\1\176",
			"\1\177",
			"",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22",
			"\12\22\7\uffff\32\22\6\uffff\32\22\107\uffff\73\22"
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( SELECT | COUNT | FICHIER | NUMERO | NOMBRE | ENTRE | MOIS | ANNEE | JOUR | ET | OU | POINT | TEXTE | DATE | CHAR | VAR | WS );";
		}
	}

}
