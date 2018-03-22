// $ANTLR 3.5.1 /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g 2017-12-19 01:51:49

    package main.sql.output;
    import main.sql.data.Arbre;
    import java.util.function.Function;
    import java.lang.Runnable;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Tal_sqlParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANNEE", "CHAR", "COUNT", "DATE", 
		"ENTRE", "ET", "FICHIER", "JOUR", "MOIS", "NOMBRE", "NUMERO", "OU", "POINT", 
		"SELECT", "TEXTE", "VAR", "WS"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public Tal_sqlParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public Tal_sqlParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Tal_sqlParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g"; }



	// $ANTLR start "listerequetes"
	// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:57:1: listerequetes returns [Arbre lr_arbre = new Arbre(\"\")] : r= requete ( POINT )? ;
	public final Arbre listerequetes() throws RecognitionException {
		Arbre lr_arbre =  new Arbre("");


		Arbre r =null;

		try {
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:57:55: (r= requete ( POINT )? )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:58:3: r= requete ( POINT )?
			{
			pushFollow(FOLLOW_requete_in_listerequetes298);
			r=requete();
			state._fsp--;

			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:58:15: ( POINT )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==POINT) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:58:15: POINT
					{
					match(input,POINT,FOLLOW_POINT_in_listerequetes300); 
					}
					break;

			}


							lr_arbre.ajouteFils(r);
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return lr_arbre;
	}
	// $ANTLR end "listerequetes"



	// $ANTLR start "requete"
	// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:64:1: requete returns [Arbre req_arbre = new Arbre(\"\")] : SELECT ( NOMBRE | FICHIER | NUMERO | DATE ) ( TEXTE | DATE ) (ps= params )? ;
	public final Arbre requete() throws RecognitionException {
		Arbre req_arbre =  new Arbre("");


		Arbre ps =null;

		Arbre ps_arbre;
		try {
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:65:26: ( SELECT ( NOMBRE | FICHIER | NUMERO | DATE ) ( TEXTE | DATE ) (ps= params )? )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:66:3: SELECT ( NOMBRE | FICHIER | NUMERO | DATE ) ( TEXTE | DATE ) (ps= params )?
			{
			match(input,SELECT,FOLLOW_SELECT_in_requete328); 

							req_arbre.ajouteFils(new Arbre("","select "));
						
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:70:3: ( NOMBRE | FICHIER | NUMERO | DATE )
			int alt2=4;
			switch ( input.LA(1) ) {
			case NOMBRE:
				{
				alt2=1;
				}
				break;
			case FICHIER:
				{
				alt2=2;
				}
				break;
			case NUMERO:
				{
				alt2=3;
				}
				break;
			case DATE:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:70:4: NOMBRE
					{
					match(input,NOMBRE,FOLLOW_NOMBRE_in_requete339); 

								String columns = "";
								String displayColumns = "count(distinct texte.fichier)" + columns;
								req_arbre.ajouteFils(new Arbre("", displayColumns));
								req_arbre.setStringData("columns", columns);
								
					}
					break;
				case 2 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:77:5: FICHIER
					{
					match(input,FICHIER,FOLLOW_FICHIER_in_requete350); 

								String columns = "texte.fichier";
								String displayColumns = "string_agg(mot, ',') as mots, " + columns;
								req_arbre.ajouteFils(new Arbre("",displayColumns));
								req_arbre.setStringData("columns", columns);
								
					}
					break;
				case 3 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:84:6: NUMERO
					{
					match(input,NUMERO,FOLLOW_NUMERO_in_requete362); 

								String columns = "texte.numero";
								String displayColumns = "string_agg(mot, ',') as mots, " + columns;
								req_arbre.ajouteFils(new Arbre("",displayColumns));
								req_arbre.setStringData("columns", columns);
								
					}
					break;
				case 4 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:91:5: DATE
					{
					match(input,DATE,FOLLOW_DATE_in_requete373); 

								String columns = "cast(jour as INT), mois, annee, texte.fichier";
								String displayColumns = "string_agg(mot, ',') as mots, " + columns;
								req_arbre.ajouteFils(new Arbre("", displayColumns));
								req_arbre.setStringData("columns", columns);
							
					}
					break;

			}

			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:98:3: ( TEXTE | DATE )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==TEXTE) ) {
				alt3=1;
			}
			else if ( (LA3_0==DATE) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:98:4: TEXTE
					{
					match(input,TEXTE,FOLLOW_TEXTE_in_requete383); 

									req_arbre.ajouteFils(new Arbre("","from date"));
									req_arbre.ajouteFils(new Arbre("","left join texte on texte.fichier = date.fichier"));
								
					}
					break;
				case 2 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:103:5: DATE
					{
					match(input,DATE,FOLLOW_DATE_in_requete394); 

									req_arbre.ajouteFils(new Arbre("","from date"));
									req_arbre.ajouteFils(new Arbre("","left join texte on texte.fichier = date.fichier"));
								
					}
					break;

			}

			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:109:6: (ps= params )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ENTRE||LA4_0==VAR) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:109:6: ps= params
					{
					pushFollow(FOLLOW_params_in_requete411);
					ps=params();
					state._fsp--;

					}
					break;

			}


							ps_arbre = ps;
							if (ps_arbre != null) {
								req_arbre.ajouteFils(new Arbre("","where"));
								req_arbre.ajouteFils(ps_arbre);
								Integer paramCount = ps_arbre.getIntegerData("param_count");
								Boolean intersection = ps_arbre.getBooleanData("intersection");
								if (paramCount != null) {
									req_arbre.setIntegerData("param_count", paramCount);
								}
								if (intersection != null) {
									req_arbre.setBooleanData("intersection", intersection);
								}
							}
							
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return req_arbre;
	}
	// $ANTLR end "requete"



	// $ANTLR start "params"
	// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:128:1: params returns [Arbre les_pars_arbre = new Arbre(\"\")] : par1= param ( (conj= ET |conj= OU )? par2= param )* ;
	public final Arbre params() throws RecognitionException {
		Arbre les_pars_arbre =  new Arbre("");


		Token conj=null;
		Arbre par1 =null;
		Arbre par2 =null;

		Arbre par1_arbre, par2_arbre;
		try {
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:129:40: (par1= param ( (conj= ET |conj= OU )? par2= param )* )
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:130:3: par1= param ( (conj= ET |conj= OU )? par2= param )*
			{
			pushFollow(FOLLOW_param_in_params443);
			par1=param();
			state._fsp--;


							par1_arbre = par1;
							les_pars_arbre.ajouteFils(par1_arbre);
							if (Boolean.TRUE.equals(par1_arbre.getBooleanData("count"))) {
								les_pars_arbre.incrementIntegerData("param_count");
							}
						
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:138:3: ( (conj= ET |conj= OU )? par2= param )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= ENTRE && LA6_0 <= ET)||LA6_0==OU||LA6_0==VAR) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:138:4: (conj= ET |conj= OU )? par2= param
					{
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:138:4: (conj= ET |conj= OU )?
					int alt5=3;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==ET) ) {
						alt5=1;
					}
					else if ( (LA5_0==OU) ) {
						alt5=2;
					}
					switch (alt5) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:138:5: conj= ET
							{
							conj=(Token)match(input,ET,FOLLOW_ET_in_params458); 
							}
							break;
						case 2 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:138:17: conj= OU
							{
							conj=(Token)match(input,OU,FOLLOW_OU_in_params466); 
							}
							break;

					}

					pushFollow(FOLLOW_param_in_params474);
					par2=param();
					state._fsp--;


									par2_arbre = par2;
									les_pars_arbre.ajouteFils(new Arbre("", "OR"));
									les_pars_arbre.ajouteFils(par2_arbre);
									if (Boolean.TRUE.equals(par2_arbre.getBooleanData("count"))) {
										les_pars_arbre.incrementIntegerData("param_count");				
									}
									
									System.out.println(conj);
													System.out.println(conj.getText());
									if (conj != null && "ET".equals(conj.getText())) {
										les_pars_arbre.setBooleanData("intersection", true);
									}
								
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return les_pars_arbre;
	}
	// $ANTLR end "params"



	// $ANTLR start "param"
	// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:156:1: param returns [Arbre lepar_arbre = new Arbre(\"\")] : ( (a= VAR ) | ( ENTRE (j1= JOUR )? (m1= MOIS )? (a1= ANNEE )? ET (j2= JOUR )? (m2= MOIS )? (a2= ANNEE )? ) );
	public final Arbre param() throws RecognitionException {
		Arbre lepar_arbre =  new Arbre("");


		Token a=null;
		Token j1=null;
		Token m1=null;
		Token a1=null;
		Token j2=null;
		Token m2=null;
		Token a2=null;

		try {
			// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:156:51: ( (a= VAR ) | ( ENTRE (j1= JOUR )? (m1= MOIS )? (a1= ANNEE )? ET (j2= JOUR )? (m2= MOIS )? (a2= ANNEE )? ) )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==VAR) ) {
				alt13=1;
			}
			else if ( (LA13_0==ENTRE) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:157:2: (a= VAR )
					{
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:157:2: (a= VAR )
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:157:3: a= VAR
					{
					a=(Token)match(input,VAR,FOLLOW_VAR_in_param503); 
					 
								lepar_arbre.ajouteFils(new Arbre("mot =", "'"+ a.getText() +"'"));
								lepar_arbre.setBooleanData("count", true);
								
							
					}

					}
					break;
				case 2 :
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:163:6: ( ENTRE (j1= JOUR )? (m1= MOIS )? (a1= ANNEE )? ET (j2= JOUR )? (m2= MOIS )? (a2= ANNEE )? )
					{
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:163:6: ( ENTRE (j1= JOUR )? (m1= MOIS )? (a1= ANNEE )? ET (j2= JOUR )? (m2= MOIS )? (a2= ANNEE )? )
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:164:2: ENTRE (j1= JOUR )? (m1= MOIS )? (a1= ANNEE )? ET (j2= JOUR )? (m2= MOIS )? (a2= ANNEE )?
					{
					match(input,ENTRE,FOLLOW_ENTRE_in_param517); 
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:165:5: (j1= JOUR )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==JOUR) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:165:5: j1= JOUR
							{
							j1=(Token)match(input,JOUR,FOLLOW_JOUR_in_param524); 
							}
							break;

					}

					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:166:5: (m1= MOIS )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==MOIS) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:166:5: m1= MOIS
							{
							m1=(Token)match(input,MOIS,FOLLOW_MOIS_in_param532); 
							}
							break;

					}

					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:167:5: (a1= ANNEE )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==ANNEE) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:167:5: a1= ANNEE
							{
							a1=(Token)match(input,ANNEE,FOLLOW_ANNEE_in_param540); 
							}
							break;

					}

					match(input,ET,FOLLOW_ET_in_param544); 
					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:169:5: (j2= JOUR )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==JOUR) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:169:5: j2= JOUR
							{
							j2=(Token)match(input,JOUR,FOLLOW_JOUR_in_param551); 
							}
							break;

					}

					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:170:5: (m2= MOIS )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==MOIS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:170:5: m2= MOIS
							{
							m2=(Token)match(input,MOIS,FOLLOW_MOIS_in_param559); 
							}
							break;

					}

					// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:171:5: (a2= ANNEE )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==ANNEE) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// /home/quachmau/git/lo17/correction/src/main/java/main/sql/Tal_sql.g:171:5: a2= ANNEE
							{
							a2=(Token)match(input,ANNEE,FOLLOW_ANNEE_in_param567); 
							}
							break;

					}


								Function<String, String> monthToInteger = (month) -> {
									switch (month) {
									case "JANVIER":
									return "01";
									case "FEVRIER":
									return "02";
									case "MARS":
									return "03";
									case "AVRIL":
									return "04";
									case "MAI":
									return "05";
									case "JUIN":
									return "06";
									case "JUILLET":
									return "07";
									case "AOUT":
									return "08";
									case "SEPTEMBRE":
									return "09";
									case "OCTOBRE":
									return "10";
									case "NOVEMBRE":
									return "11";
									case "DECEMBRE":
									return "12";
									default:
									return "ERROR";
									}
								};
								
								Boolean selectorPresent = false;
								
								String fm1, fm2;
								if (m1 != null && m2 != null) {
									
									fm1 = monthToInteger.apply(m1.getText());
									fm2 = monthToInteger.apply(m2.getText());
									if (selectorPresent) {
										lepar_arbre.ajouteFils(new Arbre("", "AND"));
									}
									selectorPresent = true;
									lepar_arbre.ajouteFils(new Arbre("mois >= ", "'"+ fm1 + "' AND mois <= '" + fm2 +"'"));
								}
								Integer fj1, fj2;
								if (j1 != null && j2 != null) {
									fj1 = Integer.valueOf(j1.getText());
									fj2 = Integer.valueOf(j2.getText());
									if (selectorPresent) {
										lepar_arbre.ajouteFils(new Arbre("", "AND"));
									}
									selectorPresent = true;
									lepar_arbre.ajouteFils(new Arbre("jour >= ", fj1 + " AND jour <= " + fj2));
								}
								String fa1, fa2;
								if (a1 != null && a2 != null) {
									fa1 = a1.getText();
									fa2 = a2.getText();
									if (selectorPresent) {
										lepar_arbre.ajouteFils(new Arbre("", "AND"));
									}
									selectorPresent = true;
									lepar_arbre.ajouteFils(new Arbre("annee >= ", "'" + fa1 + "' AND annee <= '" + fa2 + "'"));
								}
								
							
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return lepar_arbre;
	}
	// $ANTLR end "param"

	// Delegated rules



	public static final BitSet FOLLOW_requete_in_listerequetes298 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_POINT_in_listerequetes300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_requete328 = new BitSet(new long[]{0x0000000000006480L});
	public static final BitSet FOLLOW_NOMBRE_in_requete339 = new BitSet(new long[]{0x0000000000040080L});
	public static final BitSet FOLLOW_FICHIER_in_requete350 = new BitSet(new long[]{0x0000000000040080L});
	public static final BitSet FOLLOW_NUMERO_in_requete362 = new BitSet(new long[]{0x0000000000040080L});
	public static final BitSet FOLLOW_DATE_in_requete373 = new BitSet(new long[]{0x0000000000040080L});
	public static final BitSet FOLLOW_TEXTE_in_requete383 = new BitSet(new long[]{0x0000000000080102L});
	public static final BitSet FOLLOW_DATE_in_requete394 = new BitSet(new long[]{0x0000000000080102L});
	public static final BitSet FOLLOW_params_in_requete411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_params443 = new BitSet(new long[]{0x0000000000088302L});
	public static final BitSet FOLLOW_ET_in_params458 = new BitSet(new long[]{0x0000000000080100L});
	public static final BitSet FOLLOW_OU_in_params466 = new BitSet(new long[]{0x0000000000080100L});
	public static final BitSet FOLLOW_param_in_params474 = new BitSet(new long[]{0x0000000000088302L});
	public static final BitSet FOLLOW_VAR_in_param503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENTRE_in_param517 = new BitSet(new long[]{0x0000000000001A10L});
	public static final BitSet FOLLOW_JOUR_in_param524 = new BitSet(new long[]{0x0000000000001210L});
	public static final BitSet FOLLOW_MOIS_in_param532 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_ANNEE_in_param540 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ET_in_param544 = new BitSet(new long[]{0x0000000000001812L});
	public static final BitSet FOLLOW_JOUR_in_param551 = new BitSet(new long[]{0x0000000000001012L});
	public static final BitSet FOLLOW_MOIS_in_param559 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ANNEE_in_param567 = new BitSet(new long[]{0x0000000000000002L});
}
