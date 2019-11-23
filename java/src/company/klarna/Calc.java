package company.klarna;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calc {

  private static final String PLUS = "+";
  private static final String MINUS = "-";
  private static final String MULTIPLY = "*";
  private static final String DIVIDE = "/";

  public double evaluate(String expr) {
    if (expr == null || expr.length() == 0) {
      return 0.0D;
    }
    String[] expressions = expr.split(" ");
    Deque<Double> stack = new ArrayDeque<>();
    for (String e : expressions) {
      if (isOperator(e)) {
        if (stack.size() < 2) {
          throw new IllegalArgumentException(expr + "is not a valid expression.");
        }
        Double rightOperand = stack.pop();
        Double leftOperand = stack.pop();
        stack.push(evaluate(e, leftOperand, rightOperand));
      } else {
        stack.push(Double.valueOf(e));
      }
    }
    return stack.peek();
  }

  private double evaluate(String operator, double leftOperand, double rightOperand) {
    switch (operator) {
      case PLUS:
        return leftOperand + rightOperand;
      case MINUS:
        return leftOperand - rightOperand;
      case MULTIPLY:
        return leftOperand * rightOperand;
      case DIVIDE:
        return leftOperand / rightOperand;
      default:
        throw new IllegalArgumentException(operator + "is not a valid operator.");
    }
  }

  private boolean isOperator(String e) {
    return e.equals(PLUS) || e.equals(MINUS) || e.equals(MULTIPLY) || e.equals(DIVIDE);
  }

}
