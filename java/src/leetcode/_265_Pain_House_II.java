package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _265_Pain_House_II {

  @Test
  public void test() {
    _265_Pain_House_II q = new _265_Pain_House_II();
    int[][] costs = new int[][] {{1,5,3},{2,9,4}};
    Assert.assertEquals(5, q.minCostII(costs));
  }
  public int minCostII(int[][] costs) {
    int n = costs.length;
    int k = costs[0].length;
    if (n == 0) {
      return 0;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < k; j++) {
        int tempCost = Integer.MAX_VALUE;
        for (int l = 0; l < k; l++) {
          if (j != l) {
            tempCost = Math.min(tempCost, costs[i - 1][l] + costs[i][j]);
          }
        }
        costs[i][j] = tempCost;
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i : costs[n - 1]) {
      min = Math.min(min, i);
    }
    return min;
  }
}
