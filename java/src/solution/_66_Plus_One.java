package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午9:09
 */
public class _66_Plus_One {

  public int[] plusOne(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }
}
