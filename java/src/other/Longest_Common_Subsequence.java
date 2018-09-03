package other;

/**
 * http://www.geeksforgeeks.org/?p=12998
 *
 * @author jade on 2017/6/28 下午7:57
 */
public class Longest_Common_Subsequence {

  public static int lcs(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 0; i <= str1.length(); i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i <= str2.length(); i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int max = 0;
    for (int i = 0; i <= str1.length(); i++) {
      for (int j = 0; j <= str2.length(); j++) {
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lcs("abcd", "bcd"));
    System.out.println(lcs("ABCDGH", "AEDFHR"));
    System.out.println(lcs("AGGTAB", "GXTXAYB"));
    System.out.println(lcs("", "GXTXAYB"));
  }


}
