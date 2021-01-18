package leetcode;

import org.junit.Test;
import util.Assert;

public class _1131_Maximum_of_Absolute_Value_Expression {

  int MAX = 1000000 + 1;

  @Test
  public void test() {
    var q = new _1131_Maximum_of_Absolute_Value_Expression();
    Assert.assertEqual(13, q.maxAbsValExpr(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6}));
  }

  int[][] corners = new int[][]{
      {MAX, MAX, MAX},
      {MAX, MAX, Integer.MIN_VALUE},
      {MAX, -MAX, MAX},
      {MAX, -MAX, -MAX},
      {-MAX, MAX, MAX},
      {-MAX, MAX, -MAX},
      {-MAX, -MAX, MAX},
      {-MAX, -MAX, -MAX}
  };

  public int maxAbsValExpr(int[] arr1, int[] arr2) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < corners.length; i++) {
      int[] corner = corners[i];
      int tempMax = Integer.MIN_VALUE;
      int tempMin = Integer.MAX_VALUE;
      for (int j = 0; j < arr1.length; j++) {
        int dist =
            Math.abs(arr1[j] - corner[0]) + Math.abs(arr2[j] - corner[1]) + Math.abs(j - corner[2]);
        tempMax = Math.max(tempMax, dist);
        tempMin = Math.min(tempMin, dist);
      }
      max = Math.max(max, tempMax - tempMin);
    }
    return max;
  }
}
