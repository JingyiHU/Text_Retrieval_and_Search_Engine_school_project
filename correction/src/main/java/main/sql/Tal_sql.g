grammar Tal_sql;

@lexer::header {
    package main.sql.output;
    import main.sql.data.Arbre;
}

@parser::header {
    package main.sql.output;
    import main.sql.data.Arbre;
    import java.util.function.Function;
    import java.lang.Runnable;
}

SELECT : 'SELECT'
;

COUNT 	: 'COUNT'
;

FICHIER : 'FICHIER'
;

NUMERO : 'NUMERO'
;

NOMBRE : 'NOMBRE'
;

ENTRE : 'ENTRE';
MOIS : 'JANVIER' | 'FEVRIER' | 'MARS' | 'AVRIL' | 'MAI' | 'JUIN' |
'JUILLET' | 'AOUT' | 'SEPTEMBRE' | 'OCTOBRE' | 'NOVEMBRE' | 'DECEMBRE';
ANNEE 	:	('0'..'9')('0'..'9')('0'..'9')('0'..'9');
JOUR 	:	('0'..'9')('0'..'9')?;

ET	:	 'ET';
OU 	:	'OU';

POINT : '.'
;

TEXTE : 'TEXTE'
;

DATE : 'DATE'
;

CHAR 	: 'Â' .. 'ü'|'a'..'z'|'A'..'Z'
;

VAR 	: (CHAR | '0'..'9')+
;

WS  : (' ' |'\t' | '\r') {skip();} | '\n' 
;

listerequetes returns [Arbre lr_arbre = new Arbre("")]:
		r = requete POINT?
			{
				lr_arbre.ajouteFils($r.req_arbre);
			}
;

requete returns [Arbre req_arbre = new Arbre("")]
	@init {Arbre ps_arbre;} : 
		SELECT
			{
				req_arbre.ajouteFils(new Arbre("","select "));
			} 
		(NOMBRE
			{
			String columns = "";
			String displayColumns = "count(distinct texte.fichier)" + columns;
			req_arbre.ajouteFils(new Arbre("", displayColumns));
			req_arbre.setStringData("columns", columns);
			}
		| FICHIER
			{
			String columns = "texte.fichier";
			String displayColumns = "string_agg(mot, ',') as mots, " + columns;
			req_arbre.ajouteFils(new Arbre("",displayColumns));
			req_arbre.setStringData("columns", columns);
			}
		 | NUMERO
			{
			String columns = "texte.numero";
			String displayColumns = "string_agg(mot, ',') as mots, " + columns;
			req_arbre.ajouteFils(new Arbre("",displayColumns));
			req_arbre.setStringData("columns", columns);
			}
		| DATE
		{
			String columns = "cast(jour as INT), mois, annee, texte.fichier";
			String displayColumns = "string_agg(mot, ',') as mots, " + columns;
			req_arbre.ajouteFils(new Arbre("", displayColumns));
			req_arbre.setStringData("columns", columns);
		})
		(TEXTE
			{
				req_arbre.ajouteFils(new Arbre("","from date"));
				req_arbre.ajouteFils(new Arbre("","left join texte on texte.fichier = date.fichier"));
			}
		| DATE
			{
				req_arbre.ajouteFils(new Arbre("","from date"));
				req_arbre.ajouteFils(new Arbre("","left join texte on texte.fichier = date.fichier"));
			}
		)
		ps = params?
			{
				ps_arbre = $ps.les_pars_arbre;
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
;

params returns [Arbre les_pars_arbre = new Arbre("")]
	@init	{Arbre par1_arbre, par2_arbre;} : 
		par1 = param
			{
				par1_arbre = $par1.lepar_arbre;
				les_pars_arbre.ajouteFils(par1_arbre);
				if (Boolean.TRUE.equals(par1_arbre.getBooleanData("count"))) {
					les_pars_arbre.incrementIntegerData("param_count");
				}
			}
		((conj = ET | conj = OU)? par2 = param
			{
				par2_arbre = $par2.lepar_arbre;
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
		)*
;

param returns [Arbre lepar_arbre = new Arbre("")] :
	(a = VAR
		{ 
			lepar_arbre.ajouteFils(new Arbre("mot =", "'"+ a.getText() +"'"));
			lepar_arbre.setBooleanData("count", true);
			
		}
	) | (
	ENTRE
	j1 = JOUR?
	m1 = MOIS?
	a1 = ANNEE?
	ET
	j2 = JOUR?
	m2 = MOIS?
	a2 = ANNEE?
		{
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
	)
;

