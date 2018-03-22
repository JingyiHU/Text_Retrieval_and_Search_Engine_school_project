package main.tokenizer;

import main.tokenizer.data.TokenType;

public enum TokenConstant {
	// REQUEST ITEMS : colonnes
	MOT(TokenType.REQUEST_ITEMS),
	FICHIER(TokenType.REQUEST_ITEMS),
	NUMERO(TokenType.REQUEST_ITEMS),
	DATE(TokenType.REQUEST_ITEMS),
	// COUNT
	NOMBRE(TokenType.REQUEST_ITEMS),
	// REQUEST TYPE
	SELECT(TokenType.REQUEST_TYPE),
	// REQUEST TABLE
	TEXTE(TokenType.REQUEST_TABLE),
	// CONJUNCTION
	ET(TokenType.CONJUNCTION),
	OU(TokenType.CONJUNCTION),
	ENTRE(TokenType.SPECIAL),
	JANVIER(TokenType.SPECIAL),
	FEVRIER(TokenType.SPECIAL),
	MARS(TokenType.SPECIAL),
	AVRIL(TokenType.SPECIAL),
	MAI(TokenType.SPECIAL),
	JUIN(TokenType.SPECIAL),
	JUILLET(TokenType.SPECIAL),
	AOUT(TokenType.SPECIAL),
	SEPTEMBRE(TokenType.SPECIAL),
	OCTOBRE(TokenType.SPECIAL),
	NOVEMBRE(TokenType.SPECIAL),
	DECEMBRE(TokenType.SPECIAL),
	;
	
	private final TokenType type;
	
	private TokenConstant(TokenType type) {
		this.type = type;
	}

	public TokenType getType() {
		return type;
	}
}
