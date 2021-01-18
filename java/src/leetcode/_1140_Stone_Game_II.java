package leetcode;

import java.util.stream.IntStream;

public class _1140_Stone_Game_II {

    public int stoneGameII(int[] piles) {
        int score = score(piles, 0, 1);
        int sum = IntStream.of(piles).sum();
        return (sum + score) / 2;
    }

    private int score(int[] piles, int i, int m) {
        if (i >= piles.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x = 1; x <= 2 * m; x++) {
            if (i + x - 1 >= piles.length) {
                break;
            }
            sum += piles[i + x - 1];
            max = Math.max(max, sum - score(piles, i + x, Math.max(x, m)));
        }
        return max;
    }
}
