package leetcode;

import java.util.TreeMap;
import org.junit.Test;
import util.Assert;

public class _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {

  @Test
  public void test() {
    var q = new _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit();
    Assert.assertEqual(2, q.longestSubarray(new int[]{8, 2, 4, 7}, 4));
  }

  public int longestSubarray(int[] nums, int limit) {
    int l = 0;
    int ans = 0;
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      treeMap.put(current, treeMap.getOrDefault(current, 0) + 1);
      while (treeMap.lastKey() - treeMap.firstKey() > limit) {
        int leftValue = nums[l++];
        treeMap.put(leftValue, treeMap.get(leftValue) - 1);
        if (treeMap.get(leftValue) == 0) {
          treeMap.remove(leftValue);
        }
      }
      ans = Math.max(ans, i - l +1);
    }
    return ans;
  }
}
