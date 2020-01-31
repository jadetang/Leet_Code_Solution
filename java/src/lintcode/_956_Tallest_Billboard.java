package lintcode;

import java.util.stream.IntStream;

public class _956_Tallest_Billboard {

  public int tallestBillboard(int[] rods) {
    int sum = IntStream.of(rods).sum();
    return sum;

  }

}
