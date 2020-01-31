package leetcode;

import java.util.Arrays;

/**
 * @author jade on 2017/7/1 上午11:39
 */
public class _14_Longest_Common_Prefix {


  public static String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else if (strs.length == 1) {
      return strs[0];
    } else {
      String prefix = strs[0];
      for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
          prefix = prefix.substring(0, prefix.length() - 1);
          if (prefix.isEmpty()) {
            return "";
          }
        }
      }
      return prefix;
    }
  }

  public static void main(String[] args) {
    String[] a = new String[]{"leetcode", "leee", "leetxxxx"};
    System.out.println(longestCommonPrefix2(a));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    } else {
      Arrays.sort(strs);
      char[] a = strs[0].toCharArray();
      char[] b = strs[strs.length - 1].toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < a.length; i++) {

        if (i > b.length || a[i] != b[i]) {
          return sb.toString();
        } else {
          sb.append(a[i]);
        }
      }
      return sb.toString();
    }
  }


}
