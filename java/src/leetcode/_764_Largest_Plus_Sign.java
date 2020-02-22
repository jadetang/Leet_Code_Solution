package leetcode;

import java.util.Arrays;
import org.junit.Test;
import util.Assert;

public class _764_Largest_Plus_Sign {

    @Test
    public void test() {
        _764_Largest_Plus_Sign q = new _764_Largest_Plus_Sign();
        int[][] mines = new int[][] {{4, 2}};
        int[][] mines2 = new int[][] {{3, 0}, {0, 3}};
        Assert.assertEqual(2, q.orderOfLargestPlusSign(5, mines));
        Assert.assertEqual(3, q.orderOfLargestPlusSign(5, mines2));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat = new int[n][n];
        for (int[] row : mat) {
            Arrays.fill(row, 1);
        }
        for (int[] mine : mines) {
            mat[mine[0]][mine[1]] = 0;
        }
        int[][] maxWidthLeftRow = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    maxWidthLeftRow[i][j] = j == 0 ? 1 : maxWidthLeftRow[i][j - 1] + 1;
                }
            }
        }
        int[][] maxWidthRightRow = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    maxWidthRightRow[i][j] = j == n - 1 ? 1 : maxWidthRightRow[i][j + 1] + 1;
                }
            }
        }
        int[][] maxHeightDown = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][j] == 1) {
                    maxHeightDown[i][j] = i == 0 ? 1 : maxHeightDown[i - 1][j] + 1;
                }
            }
        }
        int[][] maxHeightUp = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (mat[i][j] == 1) {
                    maxHeightUp[i][j] = i == n - 1 ? 1 : maxHeightUp[i + 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                        ans = Math.max(ans, 1);
                    }else {
                        int cross =
                                1 + min(maxWidthLeftRow[i][j - 1], maxWidthRightRow[i][j + 1], maxHeightUp[i + 1][j],
                                        maxHeightDown[i - 1][j]);
                        ans = Math.max(ans, cross);
                    }
                }
            }
        }
        return ans;
    }

    private int min(int i, int i1, int i2, int i3) {
        return Math.min(Math.min(i, i1), Math.min(i2, i3));
    }
}
