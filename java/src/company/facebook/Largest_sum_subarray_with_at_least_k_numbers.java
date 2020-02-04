package company.facebook;

/**
 * Given an array, find the subarray (containing at least k numbers) which has the largest sum.
 *
 * Examples:
 *
 * Input : arr[] = {-4, -2, 1, -3} k = 2 Output : -1 The sub array is {-2, 1}
 *
 * Input : arr[] = {1, 1, 1, 1, 1, 1} k = 2 Output : 6 The sub array is {1, 1, 1, 1, 1, 1} Asked in
 * : Facebook
 *
 * @author jade on 2017/6/23 上午8:37
 */
public class Largest_sum_subarray_with_at_least_k_numbers {

  public static int largestSum(int[] nums, int k) {
    int[] prefixSum = new int[nums.length + 1];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      prefixSum[i + 1] = sum;
    }
    int ans = Integer.MIN_VALUE;
    for (int l = k; l < nums.length; l++) {
      for (int i = 0; i + k < prefixSum.length; i++) {
        ans = Math.max(ans, prefixSum[i + k] - prefixSum[i]);
      }
    }
    return ans;
  }
}
