package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _1102_Path_With_Maximum_Minimum_Value {

  @Test
  public void test() {
    int[][] a = new int[][] {{5,4,5},{1,2,6},{7,4,6}};
    var q = new _1102_Path_With_Maximum_Minimum_Value();
    Assert.assertEqual(4, q.maximumMinimumPath(a));
  }

  @Test
  public void test2() {
    int[][] a = new int[][] {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
    var q = new _1102_Path_With_Maximum_Minimum_Value();
    Assert.assertEqual(3, q.maximumMinimumPath(a));
  }

  @Test
  public void test3() {
    int[][] a = new int[][] {{0,1,0,0,0,1},{0,1,1,0,0,0},{0,0,1,1,0,1},{0,1,1,1,1,0},{1,1,1,1,1,1}};
    var q = new _1102_Path_With_Maximum_Minimum_Value();
    Assert.assertEqual(0, q.maximumMinimumPath(a));
  }

  public int maximumMinimumPath(int[][] a) {
    int row = a.length;
    int col = a[0].length;
    DSU dsu = new DSU(row * col);

    PriorityQueue<Cell> queue = new PriorityQueue<>((c1, c2) -> a[c2.r][c2.c] - a[c1.r][c1.c]);

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (i == row - 1 && j == col - 1) {
          continue;
        }
        queue.offer(new Cell(i, j, row, col));
      }
    }
    Set<Cell> cellSet = new HashSet<>();
    Cell start = new Cell(0, 0, row, col);
    Cell end = new Cell(row - 1, col - 1, row, col);
    cellSet.add(start);
    cellSet.add(end);
    int ans = Integer.MAX_VALUE;
    ans = Math.min(ans, a[start.r][start.c]);
    ans = Math.min(ans, a[end.r][end.c]);
    while (!dsu.isConnected(start.getId(), end.getId())) {
      Cell currentCell = queue.poll();
      cellSet.add(currentCell);
      ans = Math.min(ans, a[currentCell.r][currentCell.c]);
      for (Cell cell : currentCell.neighbours()) {
        if (cellSet.contains(cell)) {
          dsu.connect(currentCell.getId(), cell.getId());
        }
      }
    }
    return ans;
  }


  public static class DSU {

    int[] array;
    public DSU(int n) {
      array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = i;
      }
    }

    public int find(int i) {
      if (array[i] == i) {
        return i;
      }
      array[i] = find(array[i]);
      return array[i];
    }

    public boolean isConnected(int i, int j) {
      return find(i) == find(j);
    }

    public void connect(int i, int j) {
      int rooti = find(i);
      int rootj = find(j);
      if (rooti != rootj) {
        array[rootj] = rooti;
      }
    }
  }

  public static class Cell {

    int r;

    int c;

    int rowLength;

    int colLength;

    public Cell(int r, int c, int rowLength, int colLength) {
      this.r = r;
      this.c = c;
      this.rowLength = rowLength;
      this.colLength = colLength;
    }

    public int getId() {
      return r * colLength + c;
    }

    public List<Cell> neighbours() {
      List<Cell> neighbours = new ArrayList<>();
      int[] dir = new int[]{1, 0, -1, 0, 1};
      for (int i = 0; i < 4; i++) {
        int nextR = this.r + dir[i];
        int nectC = this.c + dir[i + 1];
        if (nextR >= 0 && nextR < rowLength && nectC >= 0 && nectC < colLength) {
          neighbours.add(new Cell(nextR, nectC, rowLength, colLength));
        }
      }
      return neighbours;
    }

    @Override
    public boolean equals(Object o) {
      Cell cell = (Cell) o;
      return this.getId() == cell.getId();
    }

    @Override
    public int hashCode() {
      return this.getId();
    }
  }

}
