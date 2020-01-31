package leetcode;

/**
 * @author jade on 2017/7/2 下午9:24
 */
public class _151_Max_Prodcut_SubArray {


  public int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = nums[0];
    min[0] = nums[0];
    int res = max[0];
    for (int i = 1; i < nums.length; i++) {
      max[i] = max(nums[i] * max[i - 1], nums[i] * min[i - 1], nums[i]);
      min[i] = min(nums[i] * max[i - 1], nums[i] * min[i - 1], nums[i]);
      res = Math.max(res, max[i]);
    }
    return res;

  }

  private int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  private int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }
}
