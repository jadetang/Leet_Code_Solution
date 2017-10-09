package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of
 * adding 1 too many close). Once we add a '(' we will then discard it and try a ')' which can only
 * close a valid '('. Each of these steps are recursively called.
 *
 * @author sanguan.tangsicheng on 2017/7/1 下午12:23
 */
public class _22_Generate_Parentheses {

  public static List<String> generateParenthesis(int n) {
    List<String> result = new LinkedList<>();
    backTrace(result, "", 0, 0, n);
    return result;
  }

  private static void backTrace(List<String> result, String str, int open, int close, int n) {
    if (str.length() == n * 2) {
      result.add(str);
    } else {
      if (open < n) {
        backTrace(result, str + "(", open + 1, close, n);
      }
      if (close < open) {
        backTrace(result, str + ")", open, close + 1, n);
      }
    }
  }

  public static void main(String[] args) {
    //Set<String> set = new HashSet<>();
    //set.
    System.out.println(generateParenthesis(1));
    System.out.println(generateParenthesis(2));
    System.out.println(generateParenthesis(3));
  }

}
