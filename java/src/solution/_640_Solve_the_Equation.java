package solution;

import util.Assert;

/**
 * @author jade on 2017/7/9 上午10:14
 */
public class _640_Solve_the_Equation {

  public static void main(String[] args) {
    testExpression("x+5");
    testExpression("2x+5");
    testExpression("-x+5+5");
    testExpression("-x+5+5x");
    testExpression("-x+5+5x-10");
    testEquation("x+5-3+x=6+x-2", "x=2.0");
    testEquation("x=x", "Infinite solutions");
    testEquation("2x=x", "x=0.0");
    testEquation("2x+3x-6x=x+2", "x=-1.0");
    testEquation("x=x+2", "No solution");
    testEquation("x+x=3", "x=1.5");

  }

  private static void testEquation(String expression, String result) {
    _640_Solve_the_Equation q = new _640_Solve_the_Equation();
    String re = q.solveEquation(expression);
    Assert.assertEqual(result, re);
  }

  private static void testExpression(String s) {
    System.out.println(new Expression(s));
  }

  public String solveEquation(String equation) {
    String[] str = equation.split("=");
    Expression left = new Expression(str[0]);
    Expression right = new Expression(str[1]);
    left.coefficient = left.coefficient - right.coefficient;
    right.value = right.value - left.value;
    if (left.coefficient == 0 && right.value == 0) {
      return "Infinite solutions";
    }
    if (left.coefficient == 0 && right.value != 0) {
      return "No solution";
    }
    return "x=" + ((double) right.value) / left.coefficient;
  }

  public static class Expression {

    int coefficient;

    int value;

    public Expression(String exp) {
      parse(exp);

    }

    @Override
    public String toString() {
      return value + " " + coefficient + "x";
    }

    private void parse(String exp) {
      boolean negative = false;
      for (int i = 0; i < exp.length(); ) {
        if (exp.charAt(i) == '+') {
          i++;
          continue;
        } else if (exp.charAt(i) == '-') {
          negative = true;
          i++;
        }
        if (exp.charAt(i) == 'x') {
          if (negative) {
            coefficient--;
          } else {
            coefficient++;
          }
          negative = false;
          i++;
        } else if (Character.isDigit(exp.charAt(i))) {

          String s = "";
          while (i < exp.length() && Character.isDigit(exp.charAt(i))) {

            s = s + exp.charAt(i);
            i++;
          }
          int num = Integer.parseInt(s);
          if (negative) {
            num = -num;
            negative = false;
          }
          if (i < exp.length() && exp.charAt(i) == 'x') {
            coefficient += num;
            i++;
          } else {
            value += num;
          }
        }
      }

    }

  }

}


