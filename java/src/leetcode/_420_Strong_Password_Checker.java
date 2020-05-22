/*
package leetcode;

public class _420_Strong_Password_Checker {

  public int strongPasswordChecker(String s) {
    int length = s.length();
    int digit = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        digit++;
      }else if (Character.isLetter(c)) {
        if (i >= 2 && s.charAt(i - 1) == c && s.charAt(i - 2) == c) {

        }
      }
    }
  }
}
*/
