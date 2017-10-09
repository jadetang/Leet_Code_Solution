package solution;

import util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanguan.tangsicheng on 2017/7/9 下午3:04
 */
public class _567_Permutation_in_String {


  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() < s1.length()) {
      return false;
    } else {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s2.toCharArray()) {
        map.put(c, 0);
      }
      for (char c : s1.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      int count = s1.length();
      int l = 0, r = 0;
      while (r < s2.length()) {
        char c = s2.charAt(r);
        if (map.get(c) > 0) {
          count--;
        }
        map.put(c, map.get(c) - 1);
        r++;
        if (count == 0) {
          return true;
        }
        if (r - l == s1.length()) {
          char leftC = s2.charAt(l);
          if (map.get(leftC) >= 0) {
            count++;
          }
          map.put(leftC, map.get(leftC) + 1);
          l++;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    _567_Permutation_in_String q = new _567_Permutation_in_String();
    Assert.assertTrue(q.checkInclusion("ab", "eidbaooo"));
    Assert.assertFalse(q.checkInclusion("ac", "eidbaooo"));
  }

}
