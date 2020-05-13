package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _1153_String_Transforms_Into_Another_String {

  @Test
  public void test() {
    _1153_String_Transforms_Into_Another_String q = new _1153_String_Transforms_Into_Another_String();
    Assert.assertTrue(q.canConvert("aabcc", "ccdee"));
    Assert.assertFalse(q.canConvert("leetcode", "codeleet"));
  }

  public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2)) {
      return true;
    }
    if (str1.length() != str2.length()) {
      return false;
    }
    Map<Character, List<Integer>> charIndexs = new HashMap<>();
    for (int i = 0; i < str1.length(); i++) {
      charIndexs.computeIfAbsent(str1.charAt(i), c -> new ArrayList<>()).add(i);
    }
    for (char c : charIndexs.keySet()) {
      if (charIndexs.get(c).size() > 1) {
        if (!matchPattern(charIndexs.get(c), str2)) {
          return false;
        }
      }
    }
    return true;
  }

  boolean matchPattern(List<Integer> index, String s) {
    Character c = null;
    for (int i : index) {
      if (c != null && c != s.charAt(i)) {
        return false;
      }
      c = s.charAt(i);
    }
    return true;
  }

}
