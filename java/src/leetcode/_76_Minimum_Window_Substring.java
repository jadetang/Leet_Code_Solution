package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 *
 * Note: If there is no such window in S that covers all characters in T, return the empty string
 * "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique
 * minimum window in S.
 *
 * @author jade on 2017/7/1 下午9:44
 */
public class _76_Minimum_Window_Substring {

  public static String minWindow(String s, String t) {
    Map<Character, Integer> dict = new HashMap<>();
    for (char c : s.toCharArray()) {
      dict.put(c, 0);
    }
    for (char c : t.toCharArray()) {
      if (dict.containsKey(c)) {
        dict.put(c, dict.get(c) + 1);
      } else {
        return "";
      }
    }
    int count = t.length();
    int begin = 0;
    int end = 0;
    int d = Integer.MAX_VALUE;
    int head = 0;
    while (end < s.length()) {
      char x = s.charAt(end);
      end++;
      if (dict.get(x) > 0) {  //表示 x 在 t 中
        count--;
      }
      dict.put(x, dict.get(x) - 1);
      while (count == 0) {
        if (end - begin < d) {
          head = begin;
          d = end - head;
        }
        char x2 = s.charAt(begin);
        begin++;
        dict.put(x2, dict.get(x2) + 1);
        if (dict.get(x2) > 0) {  //表示 x yij 不在 t 中了
          count++;
        }
      }
    }
    return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
  }

  public String minWindow2(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int unmatched = t.length();
    int r = 0;
    int length = s.length() + 1;
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) >= 0) {
          unmatched--;
        }
      }
      while (unmatched == 0) {
        int newLength = i - r + 1;
        if (newLength < length) {
          length = newLength;
          ans = s.substring(r, i + 1);
        }
        c = s.charAt(r);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
          if (map.get(c) > 0) {
            unmatched++;
          }
        }
        r++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("bba", "ab"));
  }

}
