package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tag.DynamicProgramming;
import tag.Math;

/**
 * @author jade on 2016/10/10 下午9:12
 */
public class _368_Largest_Divisible_Subset implements DynamicProgramming, Math {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> result = new LinkedList<>();
    if (nums.length == 1) {
      result.add(nums[0]);
      return result;
    }
    Arrays.sort(nums);
    int[] dp = new int[nums.length];
    int[] index = new int[nums.length];
    Arrays.fill(dp, 1);
    Arrays.fill(index, -1);
    int maxIndex = -1;
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (dp[j] + 1 > dp[i] && nums[i] % nums[j] == 0) {
          dp[i] = dp[j] + 1;
          index[i] = j;
        }
      }
      if (dp[i] > max) {
        max = dp[i];
        maxIndex = i;
      }
    }
    for (int i = maxIndex; i != -1; i = index[i]) {
      result.add(nums[i]);
    }
    return result;

  }
}
