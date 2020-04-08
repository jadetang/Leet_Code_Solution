package leetcode;

import java.util.Arrays;
import org.junit.Test;

public class _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays {


    @Test
    public void test() {
        _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays q = new _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays();
        int[ ] nums = new int[] {1, 1, 1, 1};
        int[ ] result = q.maxSumOfThreeSubarrays(nums, 2);
        System.out.println(Arrays.toString(result));
    }


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] dp = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > k - 1) {
                sum -= nums[i - k];
                dp[i - k] = sum;
            }
        }
        return dp;
    }
}
