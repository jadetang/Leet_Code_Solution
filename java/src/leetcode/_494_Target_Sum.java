package leetcode;

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
