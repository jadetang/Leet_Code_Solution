package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _363_Max_Sum_of_Rectangle_No_Larger_Than_K {

    @Test
    public void test() {
        _363_Max_Sum_of_Rectangle_No_Larger_Than_K q = new _363_Max_Sum_of_Rectangle_No_Larger_Than_K();
        int[][] matrix = new int[][] {{1,0,1},{0,-2,3}};
        Assert.assertEquals(2, q.maxSumSubmatrix(matrix, 2));
    }

    @Test
    public void test2() {
        _363_Max_Sum_of_Rectangle_No_Larger_Than_K q = new _363_Max_Sum_of_Rectangle_No_Larger_Than_K();
        int[][] matrix = new int[][] {{2, 2, -1}};
        Assert.assertEquals(3, q.maxSumSubmatrix(matrix, 3));
    }

    int n;
    int m;
    int[][] cache;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.cache = new int[n + 1][m + 1];
        buildCache(matrix);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int i2 = i; i2 < n; i2++) {
                    for (int j2 = j; j2 < m; j2++) {
                        int sum = sum(i, j, i2, j2);
                        if (sum <= k) {
                            ans = Math.max(sum,ans);
                        }
                    }
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private void buildCache(int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cache[i + 1][j + 1] = matrix[i][j] + cache[i][j + 1] + cache[i + 1][j] - cache[i][j];
            }
        }
    }

    private int sum(int i, int j, int i2, int j2) {
        return cache[i2 + 1][j2 + 1] + cache[i][j] - cache[i2 + 1][j] - cache[i][j2 + 1];
    }
}
