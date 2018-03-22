package main.tokenizer.data;

public class Token {
	private final TokenType type;
	private final String token;

	public Token(String token, TokenType tokenType) {
		this.type = tokenType;
		this.token = token;
	}
	
	public TokenType getType() {
		return type;
	}

	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", token=" + token + "]";
	}
}
