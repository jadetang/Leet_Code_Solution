package solution;

/**
 * newton 平方根
 *
 * @author sanguan.tangsicheng on 2017/7/1 下午9:13
 */
public class _69_Sqrt {

  public int mySqrt(int x) {
    long r = x;
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return (int) r;
  }

}
