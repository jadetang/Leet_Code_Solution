package leetcode;

/**
 * @author jade on 2017/7/2 下午11:11
 */
public class _172_Factorial_Trailing_Zeroes {

  //10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum
  // of the number of 2 and the number of 5.
  //Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5.

  public int trailingZeroes(int n) {
    if (n < 5) {
      return 0;
    } else {
      return n / 5 + trailingZeroes(n / 5);
    }
  }
}
