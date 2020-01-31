package leetcode;

import level.Medium;

/**
 * @author jade on 2016/12/1 上午8:25
 */
public class _376_Wiggle_Subsequence implements Medium {

  public int wiggleMaxLength(int[] nums) {
    if (nums.length < 2) {
      return 1;
    }
    int[] up = new int[]{nums.length};
    int[] down = new int[]{nums.length};
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          up[i] = Math.max(up[i], down[j] + 1);
        } else if (nums[i] < nums[j]) {
          down[i] = Math.max(down[i], up[j] + 1);
        } else {
          down[i] = down[i - 1];
          up[j] = up[j - 1];
        }
      }
    }
    return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
  }
}
