package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1563_Shortest_path_to_the_destination {

  public static void main(String[] args) {
    _1563_Shortest_path_to_the_destination q = new _1563_Shortest_path_to_the_destination();
    int[][] targetMap = new int[][]{{0, 1}, {0, 1}, {0, 2}};
    System.out.println(q.shortestPath(targetMap));
  }

  public int shortestPath(int[][] targetMap) {
    int[] CoordinateX = {-1, 1, 0, 0};
    int[] CoordinateY = {0, 0, 1, -1};
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[targetMap.length][targetMap[0].length];
    // Write your code here
    int ans = 0;
    queue.offer(new int[]{0, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];
        visited[x][y] = true;
        if (targetMap[x][y] == 2) {
          return ans;
        }
        for (int j = 0; j < 4; j++) {
          int x1 = x + CoordinateX[j];
          int y1 = y + CoordinateY[j];
          if (x1 < 0 || x1 >= targetMap.length || y1 < 0 || y1 >= targetMap[0].length
              || visited[x1][y1] || targetMap[x1][y1] == 1) {
            continue;
          } else {
            queue.offer(new int[]{x1, y1});
          }
        }
      }
      ans++;
    }
    return -1;
  }

}
