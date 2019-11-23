package leetcode;

import java.util.Arrays;

/**
 * @author jade on 16/9/30 上午9:39
 */
public class _300_Longest_Increasing_Subsequence {


  public static void main(String[] args) {
    _300_Longest_Increasing_Subsequence q = new _300_Longest_Increasing_Subsequence();
    int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
    //int[] nums = new int[]{10};
    System.out.println(q.lengthOfLIS(nums));
  }

  public int lengthOfLIS(int[] nums) {

    int maxLIS[] = new int[nums.length];
    maxLIS[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      maxLIS[i] = dp(maxLIS, nums, i);
    }
    Arrays.sort(maxLIS);
    return maxLIS[nums.length - 1];
  }

  private int dp(int[] maxLIS, int[] nums, int end) {
    int max = Integer.MIN_VALUE;
    int num = nums[end];
    for (int i = 0; i < end; i++) {
      if (nums[i] < num) {
        if (max < maxLIS[i]) {
          max = maxLIS[i];
        }
      }
    }
    if (max == Integer.MIN_VALUE) {
      return 1;
    } else {
      return max + 1;
    }
  }
}
