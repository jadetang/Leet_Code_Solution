package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence.
 *
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3,
 * 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Show Tags Show Similar Problems
 *
 * @author jade on 2017/5/21 下午5:23
 */
public class _128_Longest_Consecutive_Sequence {

  public int longestConsecutive(int[] num) {
    Set<Integer> set = new HashSet<>();
    for (int n : num) {
      set.add(n);
    }
    int length = 0;
    for (int n : num) {
      if (set.contains(n - 1)) {
        continue;
      }
      int l = 0;
      while (set.contains(n)) {
        l++;
        n++;
      }
      length = Math.max(length, l);
    }
    return length;
  }
}