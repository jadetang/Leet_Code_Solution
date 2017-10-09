package solution;

/**
 * 表示以 i 和 j 结尾的substring是否是 p， boolean[i][j]  = boolean[i-1][j-1] && s.charAt(i) == s.charAt(j);
 *
 * @author sanguan.tangsicheng on 2017/7/1 上午9:21
 */
public class _5_Longest_Palindromic_Substring {


  public static String longestPalindrome(String str) {

    if (str == null || str.length() == 0) {
      return "";
    } else {
      boolean[][] dp = new boolean[str.length()][str.length()];
      for (int i = 0; i < str.length(); i++) {
        dp[i][i] = true;
      }
      for (int i = 0; i < str.length() - 1; i++) {
        if (str.charAt(i) == str.charAt(i + 1)) {
          dp[i][i + 1] = true;
        }
      }

      for (int k = 3; k <= str.length(); k++) {
        for (int i = 0; i < str.length() - k + 1; i++) {
          int j = i + k - 1;
          dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
        }
      }
      int max = 1;
      int start = 0;
      int end = 0;
      for (int i = 0; i < str.length(); i++) {
        for (int j = i + 1; j < str.length(); j++) {
          if (dp[i][j]) {
            if (j - i + 1 > max) {
              max = j - i + 1;
              start = i;
              end = j;
            }
          }
        }
      }
      return str.substring(start, end + 1);
    }


  }


}
