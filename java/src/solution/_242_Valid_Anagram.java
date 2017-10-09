package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/6 上午9:05
 */
public class _242_Valid_Anagram {

  //也可以先排序
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    } else {
      int[] h1 = hash(s);
      int[] h2 = hash(t);
      for (int i = 0; i < h1.length; i++) {
        if (h1[i] != h2[i]) {
          return false;
        }
      }
    }
    return true;
  }

  private int[] hash(String s) {
    int[] h = new int[26];
    for (char c : s.toCharArray()) {
      h[c - 'a']++;
    }
    return h;

  }
}
