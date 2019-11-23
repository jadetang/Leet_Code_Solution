package leetcode;

/**
 * @author jade on 2016/11/14 上午7:14
 */
public class _392_Is_Subsequence {

  public static void main(String[] args) {
    _392_Is_Subsequence q = new _392_Is_Subsequence();
    System.out.println(q.isSubsequence("abc", "ahbgdc"));
  }

  public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      } else {
        j++;
      }
    }
    return i == s.length();
  }
}
