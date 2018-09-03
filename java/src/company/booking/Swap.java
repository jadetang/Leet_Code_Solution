package company.booking;

/**
 * http://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
 *
 * @author jade on 2017/7/8 下午5:47
 */
public class Swap {

  public static void main(String[] args) {

    char[] s = "3580".toCharArray();

    Swap swap = new Swap();

    swap.swapMost(s, 1);

    System.out.println(swap.max);

  }

  public int max = Integer.MIN_VALUE;

  public void swapMost(char[] strs, int k) {

    if (k == 0) {
      return;
    } else {

      for (int i = 0; i < strs.length - 1; i++) {

        for (int j = i + 1; j < strs.length; j++) {

          if (strs[i] < strs[j]) {

            swap(strs, i, j);

            max = Math.max(max, Integer.parseInt(new String(strs)));

            swapMost(strs, k - 1);

            swap(strs, i, j);

          }

        }

      }

    }

  }

  private void swap(char[] str, int i, int j) {
    char x = str[i];
    str[i] = str[j];
    str[j] = x;

  }

}
