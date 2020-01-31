package other;

import java.util.LinkedList;
import java.util.List;

public class DeleteCost {


  static String[] diffBetweenTwoStrings(String source, String target) {
    int n = source.length();
    int m = target.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= m; i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[i][0] = i;
    }
    for ( int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        char sourceChar = source.charAt(i - 1);
        char targetChar = target.charAt(j - 1);
        if (sourceChar == targetChar) {
          dp[i][j] = dp[i - 1][j - 1];
        }else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
        }
      }
    }
    int i = 0;
    int j = 0;
    List<String> ops = new LinkedList<>();
    while ( i < n && j < m) {
      if (source.charAt(i) == target.charAt(j)) {
        ops.add("" + source.charAt(i));
        i++;
        j++;
      }else {
        if (dp[i+1][j] <= dp[i][j+1]) {
          ops.add("-" + source.charAt(i));
          i++;
        }else {
          ops.add("+" + target.charAt(j));
          j++;
        }
      }
    }
    while (i < n) {
      ops.add("-" + source.charAt(i));
      i++;
    }
    while (j < m) {
      ops.add("+" + target.charAt(j));
      j++;
    }
    return ops.stream().toArray(String[]::new);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 26; i++) {
      System.out.print('a' + i);
    }
  }

}
