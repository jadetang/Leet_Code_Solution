package leetcode;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class _317_Shortest_Distance_from_All_Buildings {

    @Test
    public void test() {
        _317_Shortest_Distance_from_All_Buildings q = new _317_Shortest_Distance_from_All_Buildings();
        int[][] array = new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        Assert.assertEquals(7, q.shortestDistance(array));
    }


    Distance[][] distance;

    int[][] grid;

    int n;

    int m;

    int[] direction = new int[]{1, 0, -1, 0, 1};

    public int shortestDistance(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.distance = new Distance[n][m];
        this.grid = grid;
        int building = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    bfs(i, j, new boolean[n][m]);
                }
            }
        }
        if (building == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (distance[i][j] != null && distance[i][j].reachableBuilding == building) {
                    min = Math.min(min, distance[i][j].totalDistance);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int startI, int startJ, boolean[][] visited) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < direction.length - 1; i++) {
            int nextI = startI + direction[i];
            int nextJ = startJ + direction[i + 1];
            if (valid(nextI, nextJ)) {
                visited[nextI][nextJ] = true;
                queue.offer(new int[]{nextI, nextJ});
            }
        }
        int d = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentPos = queue.poll();
                int currentX = currentPos[0];
                int currentY = currentPos[1];
                Distance distance = this.distance[currentX][currentY];
                if (distance == null) {
                    this.distance[currentX][currentY] = new Distance(d);
                } else {
                    distance.reachableBuilding++;
                    distance.totalDistance += d;
                }
                for (int j = 0; j < direction.length - 1; j++) {
                    int nextI = currentX + direction[j];
                    int nextJ = currentY + direction[j + 1];
                    if (valid(nextI, nextJ) && !visited[nextI][nextJ]) {
                        visited[nextI][nextJ] = true;
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }
            }
            d++;
        }
    }

    private boolean valid(int nextI, int nextJ) {
        return nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && grid[nextI][nextJ] == 0;
    }

    public static class Distance {

        int totalDistance;

        int reachableBuilding;

        public Distance(int totalDistance) {
            this.totalDistance = totalDistance;
            this.reachableBuilding = 1;
        }

    }

}
