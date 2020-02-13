package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _51_N_queens {

    boolean[] column;
    boolean[] digL;
    boolean[] digR;
    char[][] board;
    int n;
    Set<List<String>> ans = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        column = new boolean[n];
        digL = new boolean[2 * n - 1];
        digR = new boolean[2 * n - 1];
        board = new char[n][n];
        for (char[] r : board) {
            Arrays.fill(r, '.');
        }
        serach(0, 0);
        return new ArrayList<>(ans);
    }

    private void serach(int queens, int row) {
        if (queens == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) {
                list.add(new String(r));
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (column[col] || digL[row + col] || digR[row - col + n - 1]) {
                continue;
            }
            column[col] = digL[row + col] = digR[row - col + n - 1] = true;
            board[row][col] = 'Q';
            serach(queens + 1, row + 1);
            column[col] = digL[row + col] = digR[row - col + n - 1] = false;
            board[row][col] = '.';
        }
    }

    @Test
    public void test() {
        _51_N_queens q = new _51_N_queens();
        Assert.assertEqual(2, q.solveNQueens(4).size());
    }

}
