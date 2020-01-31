package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class ShortestPath {

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
     //   grid[sr][sc] = 0;
        int dis = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rsize = grid.length;
        int csize = grid[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                grid[x][y] = 0;
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX == tr && nextY == tc) {
                        return dis + 1;
                    }
                    if (nextX >= 0 && nextX < rsize && nextY >= 0 && nextY < csize &&
                            grid[nextX][nextY] == 1) {
                   //     grid[nextX][nextY] = 0;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            dis++;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = new int[] {1, 2, 3};

        int n  = 100;
        int[][] intput = buildInput(n);
        long start = System.currentTimeMillis();
        System.out.println(shortestCellPath(intput, 0, 0, n - 1 , n -1));
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format("take %d", cost));
    }

    private static int[][] buildInput(int n) {
        int[][] input = new int[n][n];
        for (int[] r : input) {
            Arrays.fill(r, 1);
        }
        return input;
    }

}
