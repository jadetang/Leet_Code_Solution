package solution;

import java.util.Arrays;

/**
 * @author sanguan.tangsicheng on 2017/7/1 上午11:39
 */
public class _14_Longest_Common_Prefix {


  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
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
