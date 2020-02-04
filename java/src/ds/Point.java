package ds;

import java.util.LinkedList;
import java.util.List;
import leetcode._79_Word_Search;

public class Point {


    public int x;

    public int y;
    public char[][] board;

    public Point(char[][] board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
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
