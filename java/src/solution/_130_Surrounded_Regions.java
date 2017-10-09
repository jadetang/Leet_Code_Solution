package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example, X X X X X O O X X X O X X O X X After running your function, the board should be:
 *
 * X X X X X X X X X X X X X O X X Seen
 *
 * @author sanguan.tangsicheng on 2017/7/2 下午3:45
 */
public class _130_Surrounded_Regions {


  char[][] b;

  char X = 'X';

  char O = 'O';

  char T = 'T';

  int row;

  int col;

  //从边上的 O 开始遍历，遍历过的结点标记为第三个状态，然后在一次扫描，全部重置。
  public void solve(char[][] board) {
    if (board.length == 0) {
      return;
    }
    this.b = board;
    this.row = board.length;
    this.col = board[0].length;
    for (int i = 0; i < col; i++) {
      if (b[0][i] == O) {
        bfs(0, i);
      }
      if (b[row - 1][i] == O) {
        bfs(row - 1, i);
      }
    }
    for (int i = 0; i < row; i++) {
      if (b[i][0] == O) {
        bfs(i, 0);
      }
      if (b[i][col - 1] == O) {
        bfs(i, col - 1);
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (b[i][j] == T) {
          b[i][j] = O;
        } else {
          b[i][j] = X;
        }
      }
    }
  }


  private void bfs(int x, int y) {
    // System.out.println("["+x+","+y+"]");
    if (x < 0 || x >= row || y < 0 || y >= col) {
      return;
    } else if (b[x][y] == X || b[x][y] == T) {
      return;
    } else {
      Queue<int[]> q = new LinkedList<>();
      q.offer(new int[]{x, y});
      while (!q.isEmpty()) {
        int[] array = q.poll();
        x = array[0];
        y = array[1];
        if (isValid(x, y) && b[x][y] == O) {
          b[x][y] = T;
          q.offer(new int[]{x + 1, y});

          q.offer(new int[]{x - 1, y});

          q.offer(new int[]{x, y + 1});

          q.offer(new int[]{x, y - 1});
        }
      }
    }
  }

  private boolean isValid(int x, int y) {
    return !(x < 0 || x >= row || y < 0 || y >= col);
  }

  public static void main(String[] args) {
    _130_Surrounded_Regions q = new _130_Surrounded_Regions();
    char[][] b = new char[][]{{'O'}};
    q.solve(b);
  }


}
