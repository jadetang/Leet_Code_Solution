package solution;

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
 * @author sanguan.tangsicheng on 2017/5/21 下午5:23
 */
public class _128_Longest_Consecutive_Sequence {


  //如果要去 on 的算法，就用 hashset，否则先用排序
  public int longestConsecutive(int[] num) {
    Set set = new HashSet();
    for (int n : num) {
      set.add(n);
    }
    int length = Integer.MIN_VALUE;
    for (int n : num) {

      int l = 1;
      int temp = n;
      while (set.contains(temp++)) {
        l++;
        set.remove(temp - 1);
      }
      temp = n;
      while (set.contains(temp--)) {
        l--;
        set.remove(temp + 1);
      }
      length = Math.max(length, l);

    }
    return length;

  }
}