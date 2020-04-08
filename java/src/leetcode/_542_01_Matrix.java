package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class _542_01_Matrix {

  @Test
  public void test() {
    _542_01_Matrix q = new _542_01_Matrix();
    int[][] matrix = new int[][]{{0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}};
    int[][] m = q.updateMatrix(matrix);
    for (int[] r : m) {
      System.out.println(Arrays.toString(r));
    }
  }

  boolean[][] visited;

  int n;

  int m;

  int[] dir = new int[] {1, 0, -1, 0, 1};

  public int[][] updateMatrix(int[][] matrix) {
    n = matrix.length;
    m = matrix[0].length;
    visited = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        System.out.println("[" + current[0] + ":" + current[1] + "]");
        for (int j = 0; j < 4; j++) {
          int nexti = current[0] + dir[j];
          int nextj = current[1] + dir[j + 1];
          if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= m || visited[nexti][nextj]) {
            continue;
          }
          visited[nexti][nextj] = true;
          matrix[nexti][nextj] = 1 + matrix[current[0]][current[1]];
          queue.offer(new int[]{nexti, nextj});
        }
      }
    }
    return matrix;
  }

}
