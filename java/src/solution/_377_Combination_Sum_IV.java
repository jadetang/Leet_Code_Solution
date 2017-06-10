package solution;

import java.util.Arrays;

/**
 * @author sanguan.tangsicheng on 2016/11/17 上午7:24
 */
public class _377_Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                result += combinationSum4(nums, target - nums[i]);
            }
        }
        return result;
    }


    private int dp[];

    //top down
    public int combinationSum42(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return help(nums, target);
    }

    private int help(int[] nums, int target) {
        if (dp[target] != 1) {
            return dp[target];
        } else {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target >= nums[i]) {
                    result += help(nums, target - nums[i]);
                }
            }
            dp[target] = result;
            return result;
        }
    }

    //buttom up
    public int combinationSum43(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        dp = new int[target + 1];
        dp[0] = 1;
        for (int i=1; i < dp.length ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ( i - nums[j] >= 0 ){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target+1];
    }
}
