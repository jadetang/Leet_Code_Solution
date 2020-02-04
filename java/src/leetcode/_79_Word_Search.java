package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import level.Medium;
import tag.Array;
import tag.Backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid. The word can be constructed
 * from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example, Given board =
 *
 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true, word = "ABCB", -> returns false.
 *
 * @author jade on 2017/5/9 下午5:43
 */
public class _79_Word_Search implements Array, Backtracking, Medium {


  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'A', 'A'}
    };
    _79_Word_Search w = new _79_Word_Search();
    System.out.println(w.exist(board, "AAA"));
    System.out.println(w.exist(board, "SEE"));
    System.out.println(w.exist(board, "ABCB"));
  }

  int row;
  int col;
  boolean[][] used;
  int[] dir = new int[] {1, 0, -1, 0, 1};
  public boolean exist(char[][] board, String word) {
    row = board.length;
    col = board[0].length;
    used = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        boolean result = dfs(board, word, 0, i, j);
        if (result) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int index, int r, int c) {
    if (index == word.length()) {
      return true;
    }
    if (r < 0 || r >= row || c < 0 || c >= col) {
      return false;
    }
    if (used[r][c]) {
      return false;
    }
    if (board[r][c] != word.charAt(index)) {
      return false;
    }
    boolean result = false;
    used[r][c] = true;
    for (int i = 0; i < 4; i++) {
      int nextRow = r + dir[i];
      int nextCol = c + dir[i + 1];
      result |= dfs(board, word, index + 1, nextRow, nextCol);
      if (result) {
        return true;
      }
    }
    used[r][c] = false;
    return result;
  }

}

