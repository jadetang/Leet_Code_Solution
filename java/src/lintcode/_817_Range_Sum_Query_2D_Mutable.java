package lintcode;

import ds.FenwickTree;

public class _817_Range_Sum_Query_2D_Mutable {


  public static void main(String[] args) {
    //  int[][] data = new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
    int[][] data = new int[][]{{1}};
    NumMatrix numMatrix = new NumMatrix(data);
    System.out.println(numMatrix.sumRegion(0, 0, 0, 0));
    //System.out.println(numMatrix.sumRegion(2,1,4,3));
    numMatrix.update(0, 0, -1);
    System.out.println(numMatrix.sumRegion(0, 0, 0, 0));

  }

  public static class NumMatrix {

    FenwickTree[] trees;

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
      trees = new FenwickTree[matrix.length];
      this.matrix = matrix;
      for (int i = 0; i < trees.length; i++) {
        trees[i] = new FenwickTree(matrix[i]);
      }
    }

    public void update(int row, int col, int val) {
      trees[row].incr(col, val - this.matrix[row][col]);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for (int i = row1; i <= row2; i++) {
        sum += trees[i].getSum(col2) - trees[i].getSum(col1 - 1);
      }
      return sum;
    }
  }


}
