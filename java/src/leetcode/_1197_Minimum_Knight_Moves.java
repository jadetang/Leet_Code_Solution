package leetcode;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class _1197_Minimum_Knight_Moves {

  @Test
  public void test() {
    _1197_Minimum_Knight_Moves q = new _1197_Minimum_Knight_Moves();
    Assert.assertEquals(1, q.minKnightMoves(2, 1));
  }
  public int minKnightMoves(int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    Set<Point> visited = new HashSet<>();
    Point start = new Point(0, 0);
    queue.offer(start);
    visited.add(start);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Point p = queue.poll();
        if (p.x == x && p.y == y) {
          return ans;
        }
        for (Point nextP : p.moves()) {
          if (Math.abs(nextP.x - x) >= 2 *Math.abs(x) || Math.abs(nextP.y - y) >= 2 *Math.abs(y)) {
            continue;
          }
          if (visited.add(nextP)) {
            queue.offer(nextP);
          }
        }
      }
      ans++;
    }
    throw new RuntimeException("invalid");
  }

  public static class Point{

    int x;

    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public List<Point> moves() {
      List<Point> points = new ArrayList<>();
      int[] x = new int[] {-2, -1, 1, 2};
      int[] y = new int[] {-2, -1, 1, 2};
      for (int i = 0; i < x.length; i++) {
        for (int j = 0; j < y.length; j++) {
          if (Math.abs(x[i]) != Math.abs(y[j])) {
            points.add(new Point(this.x + x[i], this.y + y[j]));
          }
        }
      }
      return points;
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
