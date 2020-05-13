package ds;

public class Token {

  public TokenType type;
  public Integer value;

  public Token(TokenType type, int value) {
    this.type = type;
    this.value = value;
  }

  public Token(TokenType type) {
    this.type = type;
  }

  public enum TokenType {
    ADD, MINUS, MULTI, DIVISION, INT, LPAREN, RPAREN;
  }
}