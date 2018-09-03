package solution;

import company.Amazon;
import level.Easy;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to
 * reach the top of the floor, and you can either start from the step with index 0, or the step with
 * index 1.
 *
 * Example 1: Input: cost = [10, 15, 20] Output: 15 Explanation: Cheapest is start on cost[1], pay
 * that cost and go to the top. Example 2: Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3]. Note:
 * cost will have a length in the range [2, 1000]. Every cost[i] will be an integer in the range [0,
 * 999].
 */
public class _746_Min_Cost_Climbing_Stairs implements Easy, Amazon {

  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    }
    return dp[dp.length - 1];
  }

  public int minCostClimbingStairs2(int[] cost) {
    int f1 = 0, f2 = 0;
    for (int i = cost.length - 1; i >= 0; --i) {
      int f0 = cost[i] + Math.min(f1, f2);
      f2 = f1;
      f1 = f0;
    }
    return Math.min(f1, f2);
  }
}
