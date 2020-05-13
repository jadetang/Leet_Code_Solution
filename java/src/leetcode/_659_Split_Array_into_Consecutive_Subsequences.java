package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _659_Split_Array_into_Consecutive_Subsequences {

  @Test
  public void test() {
    _659_Split_Array_into_Consecutive_Subsequences q = new _659_Split_Array_into_Consecutive_Subsequences();
    int[] nums = new int[]{1, 2, 3, 3, 4, 5};
    Assert.assertTrue(q.isPossible(nums));
    int[] nums2 = new int[]{1, 2, 3, 3, 4, 4, 5, 5};
    Assert.assertTrue(q.isPossible(nums2));
    int[] nums3 = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
    Assert.assertTrue(q.isPossible(nums3));
  }

  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> sequenceCount = new HashMap<>();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    for (int i = 0; i < nums.length; i++) {
      int currentNumber = nums[i];
      if (count.getOrDefault(currentNumber, 0) == 0) {
        continue;
      }
      count.put(currentNumber, count.get(currentNumber) - 1);
      if (sequenceCount.getOrDefault(currentNumber - 1, 0) > 0) {
        sequenceCount.put(currentNumber - 1, sequenceCount.get(currentNumber - 1) - 1);
        sequenceCount.put(currentNumber, sequenceCount.getOrDefault(currentNumber, 0) + 1);
      } else {
        if (count.getOrDefault(currentNumber + 1, 0) == 0
            || count.getOrDefault(currentNumber + 2, 0) == 0) {
          return false;
        }
        count.put(currentNumber + 1, count.get(currentNumber + 1) - 1);
        count.put(currentNumber + 2, count.get(currentNumber + 2) - 1);
        sequenceCount.put(currentNumber + 2, sequenceCount.getOrDefault(currentNumber + 2, 0) + 1);
      }
    }
    return true;
  }
}
