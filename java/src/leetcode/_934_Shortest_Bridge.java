package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;

public class _934_Shortest_Bridge {

  @Test
  public void test() {
    _934_Shortest_Bridge q = new _934_Shortest_Bridge();
    int[][] a = new int[][] {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    Assert.assertEquals(1, q.shortestBridge(a));
  }

  @Test
  public void test2() {
    _934_Shortest_Bridge q = new _934_Shortest_Bridge();
    int[][] a = new int[][] {{1, 0},{0,1}};
    Assert.assertEquals(1, q.shortestBridge(a));
  }

  int n;
  int m;
  int[] dir = new int[]{1, 0, -1, 0, 1};
  boolean[][] visited;
  public int shortestBridge(int[][] a) {
    Queue<int[]> queue = new LinkedList<>();
    n = a.length;
    m = a[0].length;
    visited = new boolean[n][m];
    outer: for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 1) {
          dfs(queue, visited, i, j, a);
          break outer;
        }
      }
    }
    int distance = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        for (int j = 0; j < 4; j++) {
          int nexti = current[0] + dir[j];
          int nextj = current[1] + dir[j + 1];
          if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= m || visited[nexti][nextj]) {
            continue;
          }
          if (a[nexti][nextj] == 1) {
            return distance;
          }
          visited[nexti][nextj] = true;
          queue.offer(new int[]{nexti, nextj});
        }
      }
      distance++;
    }
    return -1;
  }

  private void dfs(Queue<int[]> queue, boolean[][] visited, int i, int j, int[][] a) {
    if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || a[i][j] == 0) {
      return;
    }
    queue.offer(new int[]{i, j});
    visited[i][j] = true;
    for (int k = 0; k < 4; k++) {
      dfs(queue, visited, i + dir[k], j + dir[k + 1], a);
    }
  }
}
