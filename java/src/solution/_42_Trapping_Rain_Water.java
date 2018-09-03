package solution;

/**
 * @author jade on 2017/7/1 下午5:48
 */
public class _42_Trapping_Rain_Water {

  public int trap(int[] height) {
    if (height.length < 3) {
      return 0;
    }
    int ans = 0;
    int l = 0;
    int r = height.length - 1;
    //先找到两边能存水的
    while (l < r && height[l] < height[l + 1]) {
      l++;
    }
    while (l < r && height[r] < height[r + 1]) {
      r--;
    }
    while (l < r) {
      int left = height[l];
      int right = height[r];

      if (left <= right) {
        while (l < r && height[++l] <= left) {
          ans += left - height[l];
        }
      } else {
        while (l < r && height[--r] <= right) {
          ans += right - height[r];
        }
      }
    }
    return ans;

  }
}
