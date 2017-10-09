package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/6/7 下午9:00
 */
public class _592_Fraction_Addition_and_Subtraction {

  public String fractionAddition(String expression) {

    char[] chars = expression.toCharArray();

    List<Fraction> fractionList = new LinkedList<>();

    char preSign = '+';
    for (int i = 0; i < chars.length; ) {
      if (chars[i] == '+' || chars[i] == '-') {
        preSign = chars[i] == preSign ? '+' : '-';
        i++;
      } else {
        StringBuilder sb = new StringBuilder();
        while (chars[i] != '/') {
          sb.append(chars[i]);
          i++;
        }
        int numerator = Integer.valueOf(sb.toString());
        i++;
        sb = new StringBuilder();
        while (i < chars.length && chars[i] != '+' && chars[i] != '-') {
          sb.append(chars[i]);
          i++;
        }
        int denominator = Integer.valueOf(sb.toString());
        fractionList.add(new Fraction(numerator, denominator, preSign));
        preSign = '+';
      }
    }
    return fractionList.stream().reduce((fraction, fraction2) -> fraction.plus(fraction2)).get()
        .toString();
  }

  public static class Fraction {

    int numerator;

    int denominator;

    public Fraction(int numerator, int denominator, char sign) {

      this.numerator = sign == '+' ? numerator : -numerator;
      this.denominator = denominator;

    }

    public Fraction plus(Fraction that) {

      int newNumerator = this.numerator * that.denominator + this.denominator * that.numerator;

      int newDenominator = this.denominator * that.denominator;

      return new Fraction(newNumerator, newDenominator, '+');

    }

    @Override
    public String toString() {
      if (numerator == 0) {
        return "0/" + denominator;
      } else {
        int gcd = GCD(Math.abs(numerator), denominator);
        return numerator / gcd + "/" + denominator / gcd;
      }
    }

  }

  public static int GCD(int m, int n) {
    if (m < n) {
      int temp = m;
      m = n;
      n = temp;
    }
    if (m % n == 0) {
      return n;
    } else {
      return GCD(n, m % n);
    }
  }

  public static void main(String[] args) {
    _592_Fraction_Addition_and_Subtraction f = new _592_Fraction_Addition_and_Subtraction();
    System.out.println(f.fractionAddition("-5/2+10/3+7/9"));
    System.out.println(f.fractionAddition("-1/2+1/2+1/3"));

    //  System.out.println(new Fraction(0, 4, '-'));
  }

}
