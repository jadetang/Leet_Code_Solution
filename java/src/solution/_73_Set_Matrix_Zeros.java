package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午9:21
 */
public class _73_Set_Matrix_Zeros {

  /**
   * My idea is simple: store states of each row in the first of that row, and store states of each
   * column in the first of that column. Because the state of row0 and the state of column0 would
   * occupy the same cell, I let it be the state of row0, and use another variable "col0" for
   * column0. In the first phase, use matrix elements to set states in a top-down way. In the second
   * phase, use states to set matrix elements in a bottom-up way. 用第一行和第一列的值存整个行或者列是否有0
   */

  public void setZeroes(int[][] matrix) {
    boolean col0 = false;
    int row = matrix.length;
    int col = matrix[0].length;

    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == 0) {
        col0 = true;
      }
      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 1; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (col0) {
        matrix[i][0] = 0;
      }
    }
  }
}
