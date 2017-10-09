package solution;

/**
 * 两边扫描，哪边的墙矮就往中间移动
 *
 * @author sanguan.tangsicheng on 2017/7/1 上午10:05
 */
public class _11_Container_With_Most_Water {

  public int maxArea(int[] height) {
    int l = 0;
    int r = height.length - 1;
    int max = 0;
    while (l < r) {
      max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return max;
  }

}