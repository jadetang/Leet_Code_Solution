package leetcode;

import java.util.PriorityQueue;
import level.Medium;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent
 * to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab" Output: "aba" Example 2:
 *
 * Input: S = "aaab" Output: "" Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class _767_Reorganize_String implements Medium {

  public static void main(String[] args) {
    _767_Reorganize_String q = new _767_Reorganize_String();
    System.out.println(q.reorganizeString("aab"));
  }


  public String reorganizeString(String s) {
    int n = s.length();
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    PriorityQueue<CharCount> pq = new PriorityQueue<>(
        (o1, o2) -> o1.count == o2.count ? o1.c - o2.c : o2.count - o1.count);
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        if (count[i] > (n + 1) / 2) {
          return "";
        } else {
          char c = (char) (i + 'a');
          CharCount charCount = new CharCount(c, count[i]);
          pq.add(charCount);
        }
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    while (pq.size() >= 2) {
      CharCount c1 = pq.poll();
      CharCount c2 = pq.poll();
      stringBuilder.append(c1.c);
      stringBuilder.append(c2.c);
      if (--c1.count > 0) {
        pq.add(c1);
      }
      if (--c2.count > 0) {
        pq.add(c2);
      }
    }
    if (pq.size() == 1) {
      stringBuilder.append(pq.poll().c);
    }
    return stringBuilder.toString();
  }


  public static class CharCount {

    char c;
    int count;

    public CharCount(char c, int count) {
      this.c = c;
      this.count = count;
    }
  }


}
