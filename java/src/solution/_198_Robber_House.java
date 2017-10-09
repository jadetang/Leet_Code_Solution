package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/3 上午8:03
 */
public class _198_Robber_House {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[nums.length - 1];

  }


  public int rob2(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
      int temp = prevNo;
      prevNo = Math.max(prevNo, prevYes);
      prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
  }
}
