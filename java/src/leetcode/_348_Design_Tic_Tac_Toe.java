package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _348_Design_Tic_Tac_Toe {

  @Test
  public void test() {
    TicTacToe q = new TicTacToe(3);
    Assert.assertEquals(0, q.move(0, 0, 1));
    Assert.assertEquals(0, q.move(0, 2, 2));
    Assert.assertEquals(0, q.move(2, 2, 1));
    Assert.assertEquals(0, q.move(1, 1, 2));
    Assert.assertEquals(0, q.move(2, 0, 1));
    Assert.assertEquals(0, q.move(1, 0, 2));
    Assert.assertEquals(1, q.move(2, 1, 1));
  }

  @Test
  public void test2() {
    TicTacToe q = new TicTacToe(2);
    Assert.assertEquals(0, q.move(0, 0, 2));
    Assert.assertEquals(0, q.move(0, 1, 1));
    Assert.assertEquals(2, q.move(1, 1, 2));
  }



  public static class TicTacToe {

    Count[] row;
    Count[] column;
    Count rightDiagonal;
    Count leftDiagonal;
    int n;
    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
      this.n = n;
      this.row = initialize(n);
      this.column = initialize(n);
      this.rightDiagonal = new Count();
      this.leftDiagonal = new Count();
    }

    private Count[] initialize(int n) {
      Count[] array = new Count[n];
      for (int i = 0; i < n; i++) {
        array[i] = new Count();
      }
      return array;
    }


    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2:
     * Player 2 wins.
     */
    public int move(int row, int col, int player) {
      if (update(this.row[row], player)) {
        return player;
      }
      if (update(this.column[col], player)) {
        return player;
      }
      if (row == col && update(this.rightDiagonal, player)) {
        return player;
      }
      if (row + col == n - 1 && update(this.leftDiagonal, player)) {
        return player;
      }
      return 0;
    }

    private boolean update(Count r, int player) {
      if (r.draw) {
        return false;
      }
      if (r.player == -1 || r.player == player) {
        r.player = player;
        r.count++;
        return r.count == n;
      } else {
        r.draw = true;
        return false;
      }
    }


    public static class Count {

      int player;
      int count;
      boolean draw;

      public Count() {
        this.player = -1;
        this.draw = false;
      }
    }
  }
}
