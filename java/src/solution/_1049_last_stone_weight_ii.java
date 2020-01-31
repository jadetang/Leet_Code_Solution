package solution;

import tag.DynamicProgramming;

public class _1049_last_stone_weight_ii implements DynamicProgramming {

    public int lastStoneWeightII(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        //dp[i][j] = true means first i stone can from sum j
        boolean[][] dp = new boolean[a.length][sum + 1];
        dp[0][a[0]] = true;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j + a[i]] = true;
                    dp[i][Math.abs(j - a[i])] = true;
                }
            }
        }
        for (int i = 0; i <= sum; i++) {
            if (dp[a.length - 1][i]) {
                return i;
            }
        }
        return sum;
    }
}
