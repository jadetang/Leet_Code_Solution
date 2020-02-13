package leetcode;

import org.junit.Test;
import util.Assert;

/**
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1]; 2, If p.charAt(j) == '.' : dp[i][j]
 * = dp[i-1][j-1];
 *
 * 3, If p.charAt(j) == '*': here are two sub conditions:
 *     1.   if p.charAt(j-1) !=s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 *     2.   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.': dp[i][j] = dp[i-1][j]    //in this case, a* counts as
 * multiple a
 *     3. dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a or dp[i][j] =
 * dp[i][j-2]   // in this case, a* counts as empty
 *
 * @author jade on 16/7/16 上午11:50
 */
public class _10_Regular_Expression_Matching {

  @Test
  public void test() {
    _10_Regular_Expression_Matching q = new _10_Regular_Expression_Matching();
    Assert.assertTrue(q.isMatch("a","a*"));
    Assert.assertTrue(q.isMatch("aa","a*"));
  }

  public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            //  dp[i][j + 1] means a* use a multiple
            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] ||dp[i + 1][j - 1];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

}
