package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * DFS + Memorization    O(m x n)
 */

public class _329_Longest_Increasing_Path_in_a_Matrix {

  int[][] cache;

  int row;

  int col;

  int[] directions = new int[] {1, 0, -1, 0, 1};

  public int longestIncreasingPath(int[][] matrix) {
    row = matrix.length;
    col = matrix[0].length;
    cache = new int[row][col];
    int ans = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        ans = Math.max(ans, dfs(matrix, r, c));
      }
    }
    return ans;
  }

  private int dfs(int[][] matrix, int r, int c) {
    if (cache[r][c] == 0) {
      int current = matrix[r][c];
      cache[r][c] = 1;
      for (int i = 0; i < directions.length - 1; i++) {
        int nextr = r + directions[i];
        int nextc = c + directions[i + 1];
        if (nextr >=0 && nextr < row && nextc >= 0 && nextc < col && current < matrix[nextr][nextc]) {
          cache[r][c] = Math.max(cache[r][c], 1 + dfs(matrix, nextr, nextc));
        }
      }
    }
    return cache[r][c];
  }

  int[][] matrix = new int[][]{{9, 9 ,4}, {6, 6, 8}, {2, 1, 1}};

  int[][] matrix2 = new int[][]{{3, 4 ,6}, {3, 4, 6}, {2, 2, 1}};

  @Test
  public void test1() {
    _329_Longest_Increasing_Path_in_a_Matrix solution = new _329_Longest_Increasing_Path_in_a_Matrix();
    int ans = solution.longestIncreasingPath(matrix);
    Assert.assertEquals(4, ans);
  }

  @Test
  public void test2() {
    _329_Longest_Increasing_Path_in_a_Matrix solution = new _329_Longest_Increasing_Path_in_a_Matrix();
    int ans = solution.longestIncreasingPath(matrix2);
    Assert.assertEquals(4, ans);
  }

}
