package leetcode;

import java.util.stream.IntStream;
import org.junit.Test;
import util.Assert;

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {

  @Test
  public void test() {
    int[] weights = new int[]{1, 2, 3, 1, 1};
    _1011_Capacity_To_Ship_Packages_Within_D_Days q = new _1011_Capacity_To_Ship_Packages_Within_D_Days();
    Assert.assertEqual(3, q.shipWithinDays(weights, 4));
  }

  public int shipWithinDays(int[] weights, int D) {
    int r = IntStream.of(weights).sum();
    int l = IntStream.of(weights).max().getAsInt();
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (shipDays(weights, mid) <= D) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private int shipDays(int[] weights, int ship) {
    int days = 0;
    int sum = 0;
    for (int i = 0; i < weights.length; i++) {
      if (sum + weights[i] > ship) {
        days++;
        sum = weights[i];
      } else {
        sum += weights[i];
      }
    }
    return sum > 0 ? days + 1 : days;
  }

}
