package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/6 上午9:20
 */
public class _268_Missing_Number {

  public static int missingNumber(int[] nums) {
    int sum = (nums.length + 1) * (nums.length) / 2;

    for (int i : nums) {
      sum -= i;
    }
    return sum;
  }

  public static void main(String[] args) {
    int rest = missingNumber(new int[]{0, 1, 2, 4, 5, 6});
    System.out.println(rest);
  }
}
