package leetcode;

import ds.Token;
import ds.Token.TokenType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _227_Basic_Calculator_II {


  @Test
  public void test() {
    _227_Basic_Calculator_II q = new _227_Basic_Calculator_II();
    //  Assert.assertEqual(3, q.calculate("6 / 2"));
    Assert.assertEqual(4, q.calculate("1 + 6 / 2"));
  }

  public int calculate(String s) {
    var tokens = parse(s);
    var stack = new Stack<Token>();
    for (int i = 0; i < tokens.size(); i++) {
      var currentToken = tokens.get(i);
      if (currentToken.type == TokenType.INT) {
        if ((i == tokens.size() - 1) || (tokens.get(i + 1).type != TokenType.MULTI
            && tokens.get(i + 1).type != TokenType.DIVISION)) {
          if (!stack.isEmpty()) {
            var op = stack.pop();
            var leftOperand = stack.pop();
            stack.push(eval(leftOperand, currentToken, op));
          } else {
            stack.push(currentToken);
          }
        }
      } else {
        stack.push(currentToken);
      }
    }
    return stack.pop().value;
  }

  private Token eval(Token leftOperand, Token rightOperand, Token operator) {
    switch (operator.type) {
      case DIVISION:
        return new Token(TokenType.INT, leftOperand.value / rightOperand.value);
      case MULTI:
        return new Token(TokenType.INT, leftOperand.value * rightOperand.value);
      case ADD:
        return new Token(TokenType.INT, leftOperand.value + rightOperand.value);
      case MINUS:
        return new Token(TokenType.INT, leftOperand.value - rightOperand.value);
      default:
        throw new IllegalArgumentException("");
    }
  }


  private List<Token> parse(String s) {
    List<Token> tokens = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      switch (c) {
        case '*':
          tokens.add(new Token(TokenType.MULTI));
          i++;
          continue;
        case '/':
          tokens.add(new Token(TokenType.DIVISION));
          i++;
          continue;
        case '+':
          tokens.add(new Token(TokenType.ADD));
          i++;
          continue;
        case '-':
          tokens.add(new Token(TokenType.MINUS));
          i++;
          continue;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
          StringBuilder stringBuilder = new StringBuilder();
          while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
            if (Character.isDigit(s.charAt(i))) {
              stringBuilder.append(s.charAt(i));
            }
            i++;
          }
          tokens.add(new Token(TokenType.INT, Integer.parseInt(stringBuilder.toString())));
          continue;
        case ' ':
          i++;
          continue;
        default:
          throw new IllegalArgumentException("Invalid expression " + s);
      }
    }
    return tokens;
  }
}
