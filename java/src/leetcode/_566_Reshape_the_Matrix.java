package leetcode;

import level.Medium;
import tag.Array;

/**
 * @author jade on 2017/5/2 下午8:11
 */
public class _566_Reshape_the_Matrix implements Medium, Array {

  public static void main(String[] args) {
    int[][] input = new int[][]{{1, 2, 3, 4}};
    _566_Reshape_the_Matrix s = new _566_Reshape_the_Matrix();
    int[][] result = s.matrixReshape(input, 2, 2);
  }

  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if (nums[0].length * nums.length != r * c) {
      return nums;
    }
    int row = nums.length;
    int column = nums[0].length;
    int[][] result = new int[r][c];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        result[i][j] = nums[convertRow(i * c + j, row, column)][convertColumn(i * c + j, row,
            column)];
      }
    }
    return result;
  }

  private int convertRow(int offset, int row, int column) {
    return offset / column;
  }

  private int convertColumn(int offset, int row, int column) {
    return offset % column;
  }

}
