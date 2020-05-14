package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.Test;
import tag.Array;
import util.Assert;

public class _698_Partition_to_K_Equal_Sum_Subsets {


  @Test
  public void test() {
    _698_Partition_to_K_Equal_Sum_Subsets q = new _698_Partition_to_K_Equal_Sum_Subsets();
    int[] nums = new int[] {1, 1, 1};
    Assert.assertTrue(q.canPartitionKSubsets(nums, 3));
  }

  int target;
  boolean[] used;
  public boolean canPartitionKSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    int sum = IntStream.of(nums).sum();
    if (sum % k != 0) {
      return false;
    }
    target = sum / k;
    used = new boolean[nums.length];
    return dfs(nums, k, 0);
  }

  private boolean dfs(int[] nums, int k, int curSum) {
    if (k == 0) {
      for (int i = 0; i < used.length; i++) {
        if (!used[i]){
          return false;
        }
      }
      return true;
    }else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i]) {
          continue;
        }
        if (nums[i] + curSum > target) {
          break;
        }
        used[i] = true;
        if (nums[i] + curSum == target) {
          if (dfs(nums, k - 1, 0)) {
            return true;
          }
        }else if (dfs(nums, k, nums[i] + curSum)) {
          return true;
        }
        used[i] = false;
      }
      return false;
    }
  }

}
