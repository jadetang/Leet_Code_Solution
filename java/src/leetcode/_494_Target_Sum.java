package leetcode;

import org.junit.Test;
import util.Assert;

/**
 * @author jade on 2017/7/27 上午8:09
 */
public class _494_Target_Sum {

  int res = 0;

  public static void main(String[] args) {
    _494_Target_Sum q = new _494_Target_Sum();
    int[] nums = new int[]{1, 1, 1, 1, 1,};
    System.out.println(q.findTargetSumWays(nums, 3));
  }

  @Test
  public void test() {
    _494_Target_Sum q = new _494_Target_Sum();
    int[] a = new int[]{1, 1, 1, 1, 1};
    Assert.assertEqual(5, q.findTargetSumWays2(a, 3));
    int[] b = new int[]{0, 1};
    Assert.assertEqual(2, q.findTargetSumWays2(b, 1));
  }

  public int findTargetSumWays2(int[] nums, int s) {
    int offset = 1000;
    int[][] dp = new int[nums.length][offset + offset + 1];
    dp[0][nums[0] + offset] += 1;
    dp[0][-nums[0] + offset] += 1;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      for (int j = 0; j < offset + offset + 1; j++) {
        if (j - num >= 0) {
          dp[i][j] += dp[i - 1][j - num];
        }
        if (j + num < offset + offset + 1) {
          dp[i][j] += dp[i -1][j + num];
        }
      }
    }
    return dp[nums.length - 1][s + offset];
  }

  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else {
      int[] sum = sumArray(nums);
      backTrack(nums, sum, S, 0, 0);
      return res;
    }
  }

  private int[] sumArray(int[] nums) {
    int[] sum = new int[nums.length + 1];
    int acc = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      acc += nums[i];
      sum[i] = acc;
    }
    return sum;
  }

  private void backTrack(int[] nums, int[] sum, int target, int current, int index) {

    if (current > target && current - sum[index] > target) {
      return;
    }
    if (current < target && current + sum[index] < target) {
      return;
    }

    if (index == nums.length && current == target) {
      res++;
    } else if (index == nums.length) {
      return;
    } else {

      backTrack(nums, sum, target, current + nums[index], index + 1);
      backTrack(nums, sum, target, current - nums[index], index + 1);

    }
  }
}
