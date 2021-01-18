package leetcode;

import org.junit.Test;
import util.Assert;

public class _1155_Number_of_Dice_Rolls_With_Target_Sum {

  @Test
  public void test() {
    var q = new _1155_Number_of_Dice_Rolls_With_Target_Sum();
    Assert.assertEqual(1, q.numRollsToTarget(1, 6, 3));
    Assert.assertEqual(6, q.numRollsToTarget(2, 6, 7));
    Assert.assertEqual(1, q.numRollsToTarget(2, 5, 10));
    Assert.assertEqual(0, q.numRollsToTarget(1, 2, 3));
    Assert.assertEqual(222616187, q.numRollsToTarget(30, 30, 500));
  }

  private int mod = 1_000_000_007;

  public int numRollsToTarget(int d, int f, int target) {
    int[][] dp = new int[d + 1][target + 1];
    for (int i = 1; i <= f; i++) {
      if (i > target) {
        break;
      }
      dp[1][i] = 1;
    }
    for (int i = 2; i <= d; i++) {
      for (int j = 1; j <= target; j++) {
        int sum = 0;
        for (int k = 1; k <= f; k++) {
          if (j -k < 0) {
            break;
          }
          sum = (sum + dp[i - 1][j - k]) % mod;
        }
        dp[i][j] = sum % mod;
      }
    }
    return dp[d][target];
  }
}
