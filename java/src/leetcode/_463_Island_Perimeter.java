package leetcode;

/**
 * @author jade on 2016/11/20 下午8:25
 */
public class _463_Island_Perimeter {

  public static void main(String[] args) {
    _463_Island_Perimeter q = new _463_Island_Perimeter();
        /*int[][] island = new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};*/
    //int[][] island = new int[][]{{0, 1, 0, 0}};
    int[][] island = new int[][]{{0}, {1}, {0}, {0}};
    System.out.println(q.islandPerimeter(island));
  }

  public int islandPerimeter(int[][] grid) {
    boolean[][] mark = new boolean[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          mark[i][j] = true;
          count++;
        } else {
          mark[i][j] = false;
        }
      }
    }
    int perimeter = count * 4;
    System.out.println("perimeter:" + perimeter);
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (mark[i][j]) {
          perimeter -= neigbors(i, j, mark);
        }
      }
    }
    return perimeter;
  }

  private int neigbors(int i, int j, boolean[][] mark) {
    int count = 0;
    for (int x = -1; x <= 1; x += 2) {
      int tempx = x + i;
      int tempy = j;
      if (isSafe(tempx, tempy, mark.length, mark[0].length) && mark[tempx][tempy]) {
        count++;
      }
    }
    for (int y = -1; y <= 1; y += 2) {
      int tempx = i;
      int tempy = y + j;
      if (isSafe(tempx, tempy, mark.length, mark[0].length) && mark[tempx][tempy]) {
        count++;
      }
    }
    System.out.printf("i:%d,j:%d\n", i, j);
    System.out.println("count:" + count);
    return count;
  }

  private boolean isSafe(int x, int y, int xlength, int ylength) {
    if (x < 0 || x >= xlength || y < 0 || y >= ylength) {
      return false;
    } else {
      return true;
    }
  }

}
