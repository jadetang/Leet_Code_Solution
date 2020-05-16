/*
package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _803_Bricks_Falling_When_Hit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] dir = new int[] {1, 0, -1, 0, 1};
        int n = grid.length;
        int m = grid[0].length;
        int[][] g = new int[grid.length][grid[0].length];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                g[i][j] = grid[i][j];
            }
        }
        for(int[] hit : hits) {
            g[hit[0]][hit[1]] = 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new int[]{0, i});
                g[0][i] = 2;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentR = current[0];
                int currentC = current[1];
                for (int k = 0; k < 4; k++) {
                    int nextR = currentR + dir[k];
                    int nextC = currentC + dir[k + 1];
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                     && g[nextR][nextC] == 1) {
                        g[nextR][nextC] = 2;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
*/
