package lintcode;

import java.util.Arrays;

public class _602_Russian_Doll_Envelopes {

  public static void main(String[] args) {
    _602_Russian_Doll_Envelopes q = new _602_Russian_Doll_Envelopes();
    int[][] data = new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7},
        {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19},
        {16, 1}, {18, 13}, {14, 17}, {18, 19}};
    String x = null;
    System.out.println(x.toString());

  }


  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (e1, e2) -> {
      if (e1[0] == e2[0]) {
        return e1[1] - e2[1];
      } else {
        return e1[0] - e2[0];
      }
    });
    for (int i = 0; i < envelopes.length; i++) {
      System.out.println(Arrays.toString(envelopes[i]));
    }
    int[][] e = new int[envelopes.length + 1][2];
    e[0] = new int[]{-1, -1};
    for (int i = 0; i < envelopes.length; i++) {
      e[i + 1] = envelopes[i];
    }
    int[][] dp = new int[e.length][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    // 0 use it
    // 1 not use
    for (int i = 1; i < e.length; i++) {
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      if (e[i][0] > e[i - 1][0] && e[i][1] > e[i - 1][1]) {
        dp[i][0] = dp[i - 1][0] + 1;
      } else {
        int j = i - 1;
        while (j >= 0 && (e[i][0] <= e[j][0] || e[i][1] <= e[j][1])) {
          j--;
        }
        dp[i][0] = dp[j][0] + 1;
      }
    }
    for (int i = 0; i < dp.length; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }
    return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]) - 1;

    // write your code here
  }


}
