package leetcode;

import java.util.Arrays;
import org.junit.Test;
import tag.Array;

public class _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays {

  @Test
  public void test() {
    _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays q = new _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays();
    int[] nums = new int[] {1,2,1,2,6,7,5,1};
    int[] result = q.maxSumOfThreeSubarrays(nums, 2);
    System.out.println(Arrays.toString(result));
  }

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length - k + 1;
    int[] dp = new int[n];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (i > k - 1) {
        sum -= nums[i - k];
      }
      if (i >= k - 1) {
        dp[i - k + 1] = sum;
      }
    }
    int[] left = new int[n];
    int maxIndex = 0;
    for (int i = 0; i < left.length; i++) {
      if (dp[i] > dp[maxIndex]) {
        maxIndex = i;
      }
      left[i] = maxIndex;
    }
    int[] right = new int[n];
    maxIndex = right.length - 1;
    for (int i = right.length - 1; i >= 0; i--) {
      if (dp[i] >= dp[maxIndex]) {
        maxIndex = i;
      }
      right[i] = maxIndex;
    }
    int[] result = new int[3];
    Arrays.fill(result, -1);
    for (int i = k; i < n - k; i++) {
      if (result[0] == -1  || dp[i] + dp[left[i - k ]] + dp[right[i + k]] >
         dp[result[0]] + dp[result[1]] + dp[result[2]]) {
        result[0] = left[i - k];
        result[1] = i;
        result[2] = right[i + k];
      }
    }
    return result;
  }

}
