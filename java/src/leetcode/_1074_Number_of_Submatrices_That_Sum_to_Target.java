package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _1074_Number_of_Submatrices_That_Sum_to_Target {

  @Test
  public void test() {
    int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
    _1074_Number_of_Submatrices_That_Sum_to_Target q = new _1074_Number_of_Submatrices_That_Sum_to_Target();
    Assert.assertEqual(4, q.numSubmatrixSumTarget(matrix, 0));
    int[][] matrix2 = new int[][]{{0, 1, 0, 0, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
        {1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}};
    Assert.assertEqual(47, q.numSubmatrixSumTarget(matrix2, 1));
  }

  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] presum = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        presum[i][j] =
            presum[i][j - 1] + presum[i - 1][j] - presum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
    int ans = 0;
    for (int r1 = 0; r1 < n; r1++) {
      for (int r2 = r1; r2 < n; r2++) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int c = 0; c < m; c++) {
          int currentSum = presum[r2 + 1][c + 1] - presum[r1][c + 1];
          ans += hashMap.getOrDefault(currentSum - target, 0);
          hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1);
        }
      }
    }
    return ans;
  }
}
