package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.Test;
import util.Assert;

public class _835_Image_Overlap {

    @Test
    public void test() {
        _835_Image_Overlap q = new _835_Image_Overlap();
        int[][] a = new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] b = new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        Assert.assertEqual(3, q.largestOverlap(a, b));
    }

    public int largestOverlap(int[][] a, int[][] b) {
        List<Point> pointListA = covertToPointList(a);
        List<Point> pointListB = covertToPointList(b);
        Set<Point> pointBSet = new HashSet<>(pointListB);
        Set<Point> seen = new HashSet<>();
        int ans = 0;
        for (Point pointA : pointListA) {
            for (Point pointB : pointListB) {
                Point delta = new Point(pointA.x - pointB.x, pointA.y - pointB.y);
                if (!seen.contains(delta)) {
                    seen.add(delta);
                    int count = 0;
                    for (Point pa : pointListA) {
                        Point newPoint = new Point(pa.x - delta.x, pa.y - delta.y);
                        if (pointBSet.contains(newPoint)) {
                            count++;
                        }
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private List<Point> covertToPointList(int[][] points) {
        List<Point> lists = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                if (points[i][j] == 1) {
                    lists.add(new Point(i, j));
                }
            }
        }
        return lists;
    }

    public static class Point {

        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}