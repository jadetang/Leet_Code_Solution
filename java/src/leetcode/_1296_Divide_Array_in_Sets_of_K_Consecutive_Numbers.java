package leetcode;

import ds.Counter;
import java.util.Arrays;
import org.junit.Test;
import util.Assert;

public class _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {

  @Test
  public void test() {
    int[] nums = new int[]{1, 2, 4};
    _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers q = new _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers();
    Assert.assertFalse(q.isPossibleDivide(nums, 3));
  }

  @Test
  public void test2() {
    int[] nums = new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
    _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers q = new _1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers();
    Assert.assertTrue(q.isPossibleDivide(nums, 3));
  }

  public boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0) {
      return false;
    }
    Counter counter = new Counter();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      counter.increase(nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (counter.count(nums[i]) != 0) {
        for (int j = 1; j < k; j++) {
          if (counter.count(nums[i] + j) == 0) {
            return false;
          } else {
            counter.decrease(nums[i] + j);
          }
        }
        counter.decrease(nums[i]);
      }
    }
    return true;
  }
}
