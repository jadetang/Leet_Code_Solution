package leetcode;

import org.junit.Test;
import util.Assert;

public class _1277_Count_Square_Submatrices_with_All_Ones {

  @Test
  public void test() {
    int[][] matrix =
        {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };
    _1277_Count_Square_Submatrices_with_All_Ones q = new _1277_Count_Square_Submatrices_with_All_Ones();
    Assert.assertEqual(15, q.countSquares(matrix));
  }

  public int countSquares(int[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    int[][] preSum = new int[r + 1][c + 1];
    for (int i = 1; i <= r; i++) {
      for (int j = 1; j <= c; j++) {
        preSum[i][j] =
            preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
    int count = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        outloop:
        for (int i2 = i, j2 = j; i2 < r && j2 < c; i2++, j2++) {
          if (sum(preSum, i, j, i2, j2) == (i2 - i + 1) * (i2 - i + 1)) {
            count++;
          } else {
            break outloop;
          }
        }
      }
    }
    return count;
  }

  private int sum(int[][] preSum, int i, int j, int i2, int j2) {
    return preSum[i2 + 1][j2 + 1] - preSum[i2 + 1][j] - preSum[i][j2 + 1] + preSum[i][j];
  }
}
