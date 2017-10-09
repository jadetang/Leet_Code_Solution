package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午4:45
 */
public class _136_Single_Number {

  public int singleNumber(int[] nums) {
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res ^= nums[i];
    }
    return res;
  }
}
