package leetcode;

/**
 * 翻转整数，要考虑 溢出 和  以 0 结尾的情况
 *
 * @author jade on 2017/7/1 上午9:50
 */
public class _7_Reserve_Integer {

  /**
   * here are some good questions to ask before coding. Bonus points for you if you have already
   * thought through this!
   *
   * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
   *
   * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
   * then the reverse of 1000000003 overflows. How should you handle such cases?
   *
   * For the purpose of this problem, assume that your function returns 0 when the reversed integer
   * overflows.
   */
  public static int reverse(int x) {
    int result = 0;
    while (x != 0) {

      if (result > Integer.MAX_VALUE / 10) {
        return 0;
      } else {
        result = result * 10 + x % 10;
        x /= 10;
      }

    }
    return result;

  }

  public static int reverse2(int x) {
    int rec = 0;
    while (x != 0) {
      int pop = x % 10;
      rec = rec * 10 + pop;
      if (rec * 10 / 10 != rec) {
        return 0;
      } else {
        x = x / 10;
      }

    }
    return rec;
  }

  public static void main(String[] args) {
    System.out.println(reverse(-2147483648));
  }

}
