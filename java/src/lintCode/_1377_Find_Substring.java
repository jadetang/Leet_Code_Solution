package lintCode;

import java.util.HashSet;
import java.util.Set;

public class _1377_Find_Substring {

  int[] hash;

  public static void main(String[] args) {
    _1377_Find_Substring q = new _1377_Find_Substring();
    System.out.println(q.findSubstring("aabc", 1));
  }

  /**
   * @param str: The string
   * @param k: The length of the substring
   * @return: The answer
   */
  public int findSubstring(String str, int k) {
    if (str == null || str.length() < k) {
      return 0;
    }
    hash = new int[26];
    int uniqueChar = k;
    Set<String> uniqueStrs = new HashSet<>();
    int l = 0, r = 0;
    for (; r < k; r++) {
      addCharToWindow(str, r);
      if (isNotUnique(str, r)) {
        uniqueChar--;
      }
    }
    r = k - 1;
    for (; r < str.length(); ) {
      if (uniqueChar == k) {
        uniqueStrs.add(str.substring(l, r + 1));
      }
      if (!isNotUnique(str, r)) {
        uniqueChar--;
      }
      removeChartFromWindow(str, r);
      r++;
      if (r == str.length()) {
        break;
      }
      addCharToWindow(str, r);
      if (!isNotUnique(str, r)) {
        uniqueChar++;
      }
      if (!isNotUnique(str, l)) {
        uniqueChar--;
      }
      removeChartFromWindow(str, l);
      l++;
      addCharToWindow(str, l);
      if (!isNotUnique(str, l)) {
        uniqueChar++;
      }
    }
    return uniqueStrs.size();
    // Write your code here
  }


  private boolean isNotUnique(String s, int index) {
    return hash[s.charAt(index) - 'a'] != 1;
  }

  private void removeChartFromWindow(String s, int index) {
    hash[s.charAt(index) - 'a']--;
  }


  private void addCharToWindow(String s, int index) {
    hash[s.charAt(index) - 'a']++;
  }

}
