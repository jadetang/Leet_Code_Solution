package lintcode;

import java.util.Arrays;

public class _587_Two_Sum_Unique_pairs {

  public static void main(String[] args) {
    _587_Two_Sum_Unique_pairs q = new _587_Two_Sum_Unique_pairs();
    System.out.println(q.twoSum6(new int[]{1, 1, 2, 45, 46, 46}, 47));
  }


  public int twoSum6(int[] nums, int target) {
    Arrays.sort(nums);
    int l = 0;
    int r = nums.length - 1;
    int ans = 0;
    while (l < r) {
      if (nums[l] + nums[r] == target) {
        ans++;
        while (l < r && nums[l] == nums[l + 1]) {
          l++;
        }
        while (l < r && nums[r] == nums[r - 1]) {
          r--;
        }
        l++;
        r--;
      } else if (nums[l] + nums[r] < target) {
        l++;
      } else {
        r--;
      }
    }
    return ans;
    // write your code here
  }

}


