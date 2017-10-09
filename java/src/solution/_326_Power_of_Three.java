package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/7 下午8:26
 */
public class _326_Power_of_Three {


  public boolean isPowerOfThree(int n) {

    return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));


  }


}
