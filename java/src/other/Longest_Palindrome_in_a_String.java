package other;

/**
 * @author jade on 2017/6/11 下午9:44
 */
public class Longest_Palindrome_in_a_String {

  public String longestPalindrom(String str) {
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

  public static void main(String[] args) {
    Longest_Palindrome_in_a_String q = new Longest_Palindrome_in_a_String();
    System.out.println(q.longestPalindrom("forgeeksskeegfor"));
  }

}
