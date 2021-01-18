package leetcode;

public class _505_The_Maze_II {

    int left = 0;
    int right = 1;
    int up = 2;
    int down = 3;
    int dr;
    int dc;
    int maxr;
    int maxc;
    int maxValue;
    int[][] matrix;
    int[][][] cache;

    public int shortestDistance(int[][] matrix, int[] start, int[] end) {
        int min = Integer.MAX_VALUE ;
        this.matrix = matrix;
        this.dr = end[0];
        this.dc = end[1];
        this.maxc = matrix.length;
        this.maxr = matrix[0].length;
        this.maxValue = maxr * maxc + 1;
        min = Math.min(min, distance(start[0], start[1], up));
        min = Math.min(min, distance(start[0], start[1], left));
        min = Math.min(min, distance(start[0], start[1], right));
        min = Math.min(min, distance(start[0], start[1], down));
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int distance(int r, int c, int direction) {
        if (r == dr && c == dc) {
            return 0;
        } else if (isWall(r, c)) {
            return maxValue;
        } else {
            int[] nextPosition = next(r, c, direction);
            if (isWall(nextPosition[0], nextPosition[1])) {
                int min = maxValue;
                min = Math.min(min, 1 + distance(r, c - 1, left));
                min = Math.min(min, 1 + distance(r, c + 1, right));
                min = Math.min(min, 1 + distance(r - 1, c, up));
                min = Math.min(min, 1 + distance(r + 1, c, down));
                return min;
            } else {
                return 1 + distance(nextPosition[0], nextPosition[1], direction);
            }
        }
    }

    private boolean isWall(int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
            return true;
        }
        if (matrix[r][c] == 1) {
            return true;
        }
        return false;
    }

    private int[] next(int r, int c, int direction) {
        switch (direction) {
            case 0:
                return new int[]{r, c - 1};
            case 1:
                return new int[]{r, c + 1};
            case 2:
                return new int[]{r - 1, c};
            case 3:
                return new int[]{r + 1, c};
            default:
                throw new RuntimeException();
        }
    }

}
