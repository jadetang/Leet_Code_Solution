package leetcode;

import org.junit.Test;
import util.Assert;

public class _727_Minimum_Window_Subsequence {

  @Test
  public void test() {
    _727_Minimum_Window_Subsequence q = new _727_Minimum_Window_Subsequence();
    Assert.assertEqual("bcde", q.minWindow2("abcde", "bde"));
    Assert.assertEqual("bde", q.minWindow2("abcdeaaaabde", "bde"));
  }

  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    int j = 0;
    String ans = "";
    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(j)) {
        j++;
      }
      if (j == t.length()) {
        j--;
        int tempI = i;
        while (j >= 0) {
          if (s.charAt(tempI) == t.charAt(j)) {
            j--;
          }
          tempI--;
        }
        j++;
        tempI++;
        int newLength = i - tempI + 1;
        if (newLength < minLength) {
          minLength = newLength;
          ans = s.substring(tempI, i + 1);
        }
        i = tempI;
      }
    }
    return ans;
  }

  public String minWindow2(String S, String T) {
    String window = "";
    int j = 0, min = S.length() + 1;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == T.charAt(j)) {
        j++;
        if (j == T.length()) {
          int end = i + 1;
          j--;
          while (j >= 0) {
            if (S.charAt(i) == T.charAt(j)) {
              j--;
            }
            i--;
          }
          j++;
          i++;
          if (end - i < min) {
            min = end - i;
            window = S.substring(i, end);
          }
        }
      }
    }
    return window;
  }

}
