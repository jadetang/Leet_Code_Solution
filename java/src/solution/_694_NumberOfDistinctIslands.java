package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and
 * only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1: 11000 11000 00011 00011 Given the above grid map, return 1. Example 2: 11011 10000
 * 00001 11011 Given the above grid map, return 3.
 *
 * Notice that: 11 1 and 1 11 are considered different island shapes, because we do not consider
 * reflection / rotation. Note: The length of each dimension in the given grid does not exceed 50.
 */
public class _694_NumberOfDistinctIslands {

  private int[][] grid;

  private boolean[][] visited;


  public int numDistinctIslands(int[][] grid) {
    this.grid = grid;
    this.visited = new boolean[grid.length][grid[0].length];
    Set<ArrayList<Integer>> shapes = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        ArrayList<Integer> shape = new ArrayList<>();
        dfs(i, j, shape);
        if (!shape.isEmpty()) {
          shapes.add(shape);
        }
      }
    }
    return shapes.size();
  }

  private void dfs(int i, int j, ArrayList<Integer> shape) {
    if (i >= 0 && i <  grid.length && j >= 0 && j < grid[0].length && (!visited[i][j])
        && grid[i][j] == 1) {
      visited[i][j] = true;
      shape.add(0);
      dfs(i + 1, j, shape);
      dfs(i - 1, j, shape);
      dfs(i, j + 1, shape);
      dfs(i, j - 1, shape);
    }
  }
}
