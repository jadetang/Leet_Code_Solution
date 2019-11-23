package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _1367_Police_Distanc {


  int[][] pos = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{0, -1, 0}, {0, 1, 1}, {0, 0, 0}};
    _1367_Police_Distanc q = new _1367_Police_Distanc();
    q.policeDistance(matrix);
  }

  public int[][] policeDistance(int[][] matrix) {

    int[][] ans = new int[matrix.length][matrix[0].length];
    for (int[] a : ans) {
      Arrays.fill(a, -1);
    }
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    Deque<int[]> queue = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          queue.offerFirst(new int[]{i, j});
        }
      }
    }
    int depth = 0;
    Deque<int[]> tempQ = new LinkedList<>();
    while (!queue.isEmpty()) {
      int[] current = queue.pollLast();
      int r = current[0];
      int c = current[1];
      if (visited[r][c]) {
        continue;
      }
      visited[r][c] = true;
      for (int[] next : getNext(visited, matrix, r, c)) {
        tempQ.offerFirst(next);
      }
      if (matrix[r][c] == 1) {
        ans[r][c] = 0;
      } else if (matrix[r][c] == -1) {
        ans[r][c] = -1;
      } else {
        ans[r][c] = depth;
      }
      if (queue.isEmpty()) {
        queue.addAll(tempQ);
        tempQ.clear();
        depth++;
      }
    }
    return ans;
    // Write your code here
  }

  private List<int[]> getNext(boolean[][] visited, int[][] matrix, int r, int c) {
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < pos.length; i++) {
      int newR = r + pos[i][0];
      int newC = c + pos[i][1];
      if (newR < 0 || newR >= matrix.length || newC < 0 || newC >= matrix[0].length
          || visited[newR][newC] || matrix[newR][newC] != 0) {
        continue;
      } else {
        res.add(new int[]{newR, newC});
      }
    }
    return res;
  }

}
