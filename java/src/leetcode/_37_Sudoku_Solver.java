package leetcode;

import java.util.Arrays;
import org.junit.Test;

public class _37_Sudoku_Solver {
    boolean[][] rowUsed = new boolean[9][10];

    boolean[][] colUsed = new boolean[9][10];

    boolean[][][] boxUsed = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '0';
                    rowUsed[i][n] = true;
                    colUsed[j][n] = true;
                    boxUsed[getBoxRow(i)][getBoxCol(j)][n] = true;
                }
            }
        }
        fillBoard(board);
    }

    private boolean fillBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (valid(i, j, k )) {
                        board[i][j] = Character.forDigit(k, 10);
                        rowUsed[i][k] = true;
                        colUsed[j][k] = true;
                        boxUsed[getBoxRow(i)][getBoxCol(j)][k] = true;
                        if (fillBoard(board)) {
                            return true;
                        }else {
                            rowUsed[i][k] = false;
                            colUsed[j][k] = false;
                            boxUsed[getBoxRow(i)][getBoxCol(j)][k] = false;
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean valid(int r, int c, int n) {
        return !rowUsed[r][n] && !colUsed[c][n] && !boxUsed[getBoxRow(r)][getBoxCol(c)][n];
    }


    private int getBoxRow(int row) {
        return row / 3;
    }

    private int getBoxCol(int col) {
        return col / 3;
    }

    @Test
    public void test() {
        _37_Sudoku_Solver q = new _37_Sudoku_Solver();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        q.solveSudoku(board);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }
}
