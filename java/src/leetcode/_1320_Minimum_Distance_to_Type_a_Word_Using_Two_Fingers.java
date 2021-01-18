package leetcode;

import java.util.Arrays;
import org.junit.Test;
import util.Assert;

public class _1320_Minimum_Distance_to_Type_a_Word_Using_Two_Fingers {

  @Test
  public void test() {
    _1320_Minimum_Distance_to_Type_a_Word_Using_Two_Fingers q = new _1320_Minimum_Distance_to_Type_a_Word_Using_Two_Fingers();
    Assert.assertEqual(3, q.minimumDistance("CAKE"));
  }

  public int minimumDistance(String word) {
    int n = word.length();
    int[][][] dp = new int[n + 1][26][26];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < 26; j++) {
        Arrays.fill(dp[i][j], Integer.MAX_VALUE);
      }
    }
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        dp[0][i][j] = 0;
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      int v = word.charAt(i - 1) - 'A';
      for (int l = 0; l < 26; l++) {
        for (int r = 0; r < 26; r++) {
          if (dp[i - 1][l][r] != Integer.MAX_VALUE) {
            dp[i][v][r] = Math.min(dp[i][v][r], dp[i - 1][l][r] + cost(l, v));
            dp[i][l][v] = Math.min(dp[i][l][v], dp[i - 1][l][r] + cost(r, v));
          }
          if (i == word.length()) {
            ans = Math.min(ans, dp[i][v][r]);
            ans = Math.min(ans, dp[i][l][v]);
          }
        }
      }
    }
    return ans;
  }

  private int cost(int c, int r) {
    int x1 = c / 6;
    int y1 = c % 6;
    int x2 = r / 6;
    int y2 = r % 6;
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
