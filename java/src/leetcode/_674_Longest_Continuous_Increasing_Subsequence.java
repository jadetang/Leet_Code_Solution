package leetcode;

public class _674_Longest_Continuous_Increasing_Subsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
