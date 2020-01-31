package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//排序，注意去重
public class _15_3Sum {

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    _15_3Sum q = new _15_3Sum();
    System.out.println(q.threeSum(nums));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
        continue;
      }
      int j = i + 1, k = nums.length - 1;
      int target = -nums[i];
      while (j < k) {
        if (nums[j] + nums[k] == target) {
          res.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;  // skip same result
          }
          while (j < k && nums[k] == nums[k + 1]) {
            k--;  // skip same result
          }
        } else if (nums[j] + nums[k] > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return res;
  }

}
