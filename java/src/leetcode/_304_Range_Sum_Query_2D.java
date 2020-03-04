package leetcode;

public class _304_Range_Sum_Query_2D {



    int[][] sum;

    int n;

    int m;

    public _304_Range_Sum_Query_2D(int[][] matrix) {
        n = matrix.length;
        if (n > 0) {
            m = matrix[0].length;
            sum = new int[n + 1][m + 1];
            buildSum(matrix);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (n == 0) {
            return 0;
        }
        return sum[row2 + 1][col2 + 1] + sum[row1][col1]
                - sum[row2 + 1][col1] - sum[row1][col2 + 1];
    }

    private void buildSum(int[][] matrix) {
        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            for (int j = 0; j < m; j++) {
                tempSum += matrix[i][j];
                sum[i + 1][j + 1] = tempSum + sum[i][j + 1];
            }
        }
    }
}
