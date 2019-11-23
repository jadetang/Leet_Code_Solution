package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 16/9/21 下午8:28
 */
public class _18_4Sum {

  public static void main(String[] args) {
    _18_4Sum q = new _18_4Sum();
    int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
    System.out.println(q.fourSum(nums, 0));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new LinkedList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int l = j + 1;
        int r = nums.length - 1;
        while (l < r) {
          int temp = nums[i] + nums[j] + nums[l] + nums[r];
          if (target == temp) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[l]);
            list.add(nums[r]);
            result.add(list);
            l++;
            r--;
            while (l < r && nums[l] == nums[l - 1]) {
              l++;
            }
            while (r > l && nums[r] == nums[r + 1]) {
              r--;
            }
          } else if (temp < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }
    return result;
  }
}
