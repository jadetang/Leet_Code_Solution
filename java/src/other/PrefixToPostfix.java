package other;

import java.util.Scanner;

/**
 * @author sanguan.tangsicheng on 2017/5/25 下午8:56
 */
public class PrefixToPostfix {


  public String prefixToPostfix(String prefix) {
    if (prefix.length() <= 1) {
      return prefix;
    } else {
      if (!Character.isDigit(prefix.charAt(0))) {
        return prefixToPostfix(prefix.substring(1)) + prefix.charAt(0);
      } else {
        return prefix.charAt(0) + prefixToPostfix(prefix.substring(1));
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    PrefixToPostfix p = new PrefixToPostfix();
    // System.out.println(p.prefixToPostfix("*34"));
    System.out.println(p.prefixToPostfix("+1*34"));
  }
}
