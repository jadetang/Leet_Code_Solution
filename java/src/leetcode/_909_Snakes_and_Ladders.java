package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _909_Snakes_and_Ladders {

    int n;

    private Map<Integer, Integer> snakeOrLadder;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        snakeOrLadder = new HashMap<>();
        boolean leftToRight = true;
        for (int row = 0; row < n ; row++) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    if (board[row][col] != -1) {
                        snakeOrLadder.put(board[row][col],row * n + col);
                    }
                }
            }else {
                for (int col = n - 1; col >= 0; col--) {
                    if (board[row][col] != -1) {
                        snakeOrLadder.put(board[row][col],row * n + col);
                    }
                }
            }
            leftToRight = !leftToRight;
        }


        int[] dp = new int[ n * n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= 6 ; i++) {
            dp[1 + i] = 1;
        }
        for (int i = 7; i <= n * n; i++) {
            for (int j = 6; j >= 1; j++) {
                dp[i] = Math.min(dp[i], dp[i - j]);
            }
            Integer start = snakeOrLadder.get(i);
            if (start != null) {
                dp[i] = Math.min(dp[i], dp[start]);
            }
        }
        return dp[n * n + 1];
    }
}
