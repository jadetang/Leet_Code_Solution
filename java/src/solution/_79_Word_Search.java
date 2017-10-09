package solution;

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
 * @author sanguan.tangsicheng on 2017/5/9 下午5:43
 */
public class _79_Word_Search implements Array, Backtracking, Medium {

  char[][] board;

  String word;

  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.word = word;
    char b = word.charAt(0);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (b == board[i][j]) {
          StringBuilder sb = new StringBuilder();
          sb.append(b);
          Set<Point> path = new HashSet<>();
          Point start = new Point(board, i, j);
          path.add(start);
          if (help(sb, path, start)) {
            return true;
          }
        }
      }
    }
    return false;

  }

  private boolean help(StringBuilder acc, Set<Point> path, Point cur) {
    if (acc.toString().equals(word)) {
      return true;
    } else {
      char nextChar = word.charAt(acc.length());
      List<Point> adj = cur.adj();
      adj = adj.stream().filter(point -> point.getChar() == nextChar && !path.contains(point))
          .collect(Collectors.toList());
      for (Point point : adj) {
        path.add(point);
        if (help(acc.append(point.getChar()), path, point)) {
          return true;
        } else {
          path.remove(point);  //记得退栈
          acc.deleteCharAt(acc.length() - 1);
        }

      }
      return false;
    }
  }

  public static class Point {

    int x;

    int y;

    public Point(char[][] board, int x, int y) {
      this.board = board;
      this.x = x;
      this.y = y;
    }

    char[][] board;

    List<Point> adj() {
      List<Point> points = new LinkedList<>();
      for (int i = -1; i < 2; i += 2) {

        try {
          Point p = new Point(board, x + i, y);
          p.getChar();
          points.add(p);
        } catch (IndexOutOfBoundsException ignored) {

        }
      }
      for (int j = -1; j < 2; j += 2) {
        try {
          Point p = new Point(board, x, y + j);
          p.getChar();
          points.add(p);
        } catch (IndexOutOfBoundsException ignored) {

        }

      }

      return points;
    }

    char getChar() {
      return board[x][y];
    }

    @Override
    public String toString() {
      return getChar() + "";
    }

    @Override
    public int hashCode() {
      return x * board[0].length + y;
    }

    @Override
    public boolean equals(Object that) {
      Point p = (Point) that;
      return this.x == p.x && this.y == p.y;
    }

  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'A', 'A'}
    };
    _79_Word_Search w = new _79_Word_Search();
    System.out.println(w.exist(board, "AAA"));
    System.out.println(w.exist(board, "SEE"));
    System.out.println(w.exist(board, "ABCB"));
  }

}

