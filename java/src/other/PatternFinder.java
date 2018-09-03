package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jade on 2017/5/31 下午5:08
 */
public class PatternFinder {

  public int findPattern(String text, String pattern) {
    if (text == null || pattern == null || text.length() == 0 || pattern.length() == 0) {
      return 0;
    } else {

      Map<Character, Set<Integer>> dict = buildDict(text);
      int count = 0;
      Set<Integer> beginIndexs = dict.get(pattern.charAt(0));
      for (Integer index : beginIndexs) {
        int i = 1;
        for (; i < pattern.length(); i++) {
          Integer nextIndex = index + 1;
          if (dict.get(pattern.charAt(i)).contains(nextIndex)) {
            index = nextIndex;
          } else {
            break;
          }
        }
        if (i == pattern.length()) {
          count++;
        }
      }
      return count;
    }
  }

  private Map<Character, Set<Integer>> buildDict(String text) {
    Map<Character, Set<Integer>> dict = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      Character c = text.charAt(i);
      if (!dict.containsKey(c)) {
        dict.put(c, new HashSet<>());
      }
      dict.get(c).add(i);
    }
    return dict;
  }

  public static void main(String[] args) {
    PatternFinder p = new PatternFinder();
    System.out.println(p.findPattern("aaaaa", "aa"));
    System.out.println(p.findPattern("abbba", "ab"));
    System.out.println(p.findPattern("abbba", ""));
    System.out.println(p.findPattern("abcd", "ac"));
    System.out.println(p.findPattern("abc d", "c d"));
    System.out.println(p.findPattern("abc d", "c  d"));
    System.out.println(p.findPattern("abc d", "b"));
  }

}
