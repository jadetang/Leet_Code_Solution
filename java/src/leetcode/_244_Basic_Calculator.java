package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _244_Basic_Calculator {

  @Test
  public void test0() {
    _244_Basic_Calculator q = new _244_Basic_Calculator();
    String exp = "1 + 2";
    Assert.assertEqual(3, q.calculate(exp));
  }

  @Test
  public void test() {
    _244_Basic_Calculator q = new _244_Basic_Calculator();
    String exp = "(1+(4+5+2)-3)+(6+8)";
    Assert.assertEqual(23, q.calculate(exp));
  }

  @Test
  public void test2() {
    _244_Basic_Calculator q = new _244_Basic_Calculator();
    String exp = "(1+(4+5+2)-3)-(6+8)";
    Assert.assertEqual(-5, q.calculate(exp));
  }

  @Test
  public void test3() {
    _244_Basic_Calculator q = new _244_Basic_Calculator();
    String exp = "(1+(4+5+2)-3)-(6+8)";
    Assert.assertEqual(-5, q.calculate(exp));
  }

  public int calculate(String s) {
    List<Token> tokenList = parse(s);
    Stack<Token> stack = new Stack<>();
    for (Token token : tokenList) {
      if (token instanceof Rparen) {
        Stack<Token> tempStack = new Stack<>();
        while (!stack.isEmpty() && !(stack.peek() instanceof Lparen)) {
          tempStack.push(stack.pop());
        }
        stack.pop();
        stack.push(evaluate(tempStack));
      } else {
        stack.push(token);
      }
    }
    Stack<Token> tempStack = new Stack<>();
    while (!stack.empty()) {
      tempStack.push(stack.pop());
    }

    return ((Number) evaluate(tempStack)).val;
  }

  private List<Token> parse(String s) {
    List<Token> tokens = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      switch (c) {
        case '(':
          tokens.add(new Lparen());
          i++;
          continue;
        case ')':
          tokens.add(new Rparen());
          i++;
          continue;
        case '+':
          tokens.add(new Plus());
          i++;
          continue;
        case '-':
          tokens.add(new Minus());
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
          tokens.add(new Number(Integer.parseInt(stringBuilder.toString())));
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

  private Token evaluate(Stack<Token> stack) {
    while (stack.size() != 1) {
      Number left = (Number) stack.pop();
      Token op = stack.pop();
      Number right = (Number) stack.pop();
      if (op instanceof Plus) {
        stack.push(new Number(left.val + right.val));
      } else if (op instanceof Minus) {
        stack.push(new Number(left.val - right.val));
      }
    }
    return stack.pop();
  }

  public interface Token {

  }

  public static class Lparen implements Token {

  }

  public static class Rparen implements Token {

  }

  public static class Plus implements Token {

  }

  public static class Minus implements Token {

  }

  public static class Number implements Token {

    int val;

    public Number(int val) {
      this.val = val;
    }
  }

}
