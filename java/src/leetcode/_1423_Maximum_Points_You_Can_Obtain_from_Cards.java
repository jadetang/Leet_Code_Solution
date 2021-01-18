package leetcode;

import org.junit.Test;
import util.Assert;

public class _1423_Maximum_Points_You_Can_Obtain_from_Cards {

    @Test
    public void test() {
        var q = new _1423_Maximum_Points_You_Can_Obtain_from_Cards();
        Assert.assertEqual(12, q.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        Assert.assertEqual(12, q.maxScore2(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

    @Test
    public void test2() {
        var q = new _1423_Maximum_Points_You_Can_Obtain_from_Cards();
        Assert.assertEqual(4, q.maxScore2(new int[]{1,2,2}, 2));
    }

    int[][][] cache;

    public int maxScore(int[] cardPoints, int k) {
        cache = new int[cardPoints.length][cardPoints.length][k + 1];
        return max(cardPoints, 0, cardPoints.length - 1, k);
    }

    private int max(int[] cardPoints, int left, int right, int k) {
        if (cache[left][right][k] != 0) {
            return cache[left][right][k];
        }
        if (k == 1) {
            cache[left][right][k] = Math.max(cardPoints[left], cardPoints[right]);
        } else {
            cache[left][right][k] = Math.max(cardPoints[left] + max(cardPoints, left + 1, right, k - 1)
                    , cardPoints[right] + max(cardPoints, left, right - 1, k - 1));
        }
        return cache[left][right][k];
    }

    public int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[][] dp = new int[cardPoints.length][cardPoints.length];
        int minLength = n - k + 1;
        int maxLength = n;
        for (int l = minLength; l <= maxLength ; l++) {
            for (int i = 0; i < n; i++) {
                int j = l + i - 1;
                if (j < n) {
                    if (l == minLength) {
                        dp[i][j] = Math.max(cardPoints[i], cardPoints[j]);
                    }else {
                        dp[i][j] = Math.max(cardPoints[i] + dp[i + 1][j], cardPoints[j] + dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

}
