package lintCode;

import java.util.Arrays;

public class _1565_Modern_Ludo_I {


  public static void main(String[] args) {
    _1565_Modern_Ludo_I q = new _1565_Modern_Ludo_I();
    q.modernLudo(15, new int[][]{{7, 9}, {8, 14}});
  }

  public int modernLudo(int length, int[][] connections) {
    int[] dp = new int[length + 1];
    int[] path = new int[length + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int[] connection : connections) {
      path[connection[0]] = connection[1];
    }
    dp[1] = 0;
    for (int i = 1; i < dp.length; i++) {
      if (i <= 7) {
        dp[i] = 1;
      } else {
        for (int j = i - 6; i < dp.length; j++) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
        if (path[i] != 0) {
          dp[path[i]] = Math.min(dp[i], dp[path[i]]);
        }
      }
    }
    return dp[dp.length - 1];
    // Write your code here
  }


}
