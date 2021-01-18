package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _490_The_Maze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        int[] dir = new int[] {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }
            int currentR = current[0];
            int currentC = current[1];
            for (int i = 0; i < dir.length - 1; i++) {
                int dr = dir[i];
                int dc = dir[i + 1];
                int nextR = currentR + dr;
                int nextC = currentC + dc;
                while (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && maze[nextR][nextC] == 0) {
                    nextR += dr;
                    nextC += dc;
                }
                nextR -= dr;
                nextC -= dc;
                if (!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
        return false;
    }
}
