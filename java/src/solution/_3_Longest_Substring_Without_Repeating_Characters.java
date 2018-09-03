package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * //用 双指针 中间用一个 hashset，或者 array（类似于 hashset）
 *
 * @author jade on 2017/7/1 上午9:05
 */
public class _3_Longest_Substring_Without_Repeating_Characters {

  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    } else {
      int left = 0;
      int right = 0;
      int max = 0;
      int[] array = new int[256];
      while (right < s.length()) {
        if (array[s.charAt(right)] > 0) {
          while (array[s.charAt(right)] > 0) {
            array[s.charAt(left)]--;
            left++;
          }
        } else {
          array[s.charAt(right)]++;
          right++;
          max = Math.max(max, right - left);
        }
      }
      return max;
    }
  }


  public static int lengthOfLongestSubstring2(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();

    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        max = Math.max(max, set.size());
      } else {
        set.remove(s.charAt(i++));
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
}
