package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/6/5 上午10:40
 */
public class _529_Minesweeper {

    public static char MINE = 'M';

    public static char EMPTY = 'E';

    public static char X = 'X';

    public static char BLANK = 'B';

    public char[][] updateBoard(char[][] board, int[] click) {
        click(board, click);
       // _529_Minesweeper.print(board);
        if (board[click[0]][click[1]] == MINE) {
            return board;
        } else {
            update(board, click);
            return board;
        }
    }

    public void update(char[][] board, int[] start) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(start);
        boolean[][] visited = new boolean[board.length][board[0].length];
        while (!list.isEmpty()) {
            int[] click = list.pollFirst();
            visited[click[0]][click[1]] = true;
            if (board[click[0]][click[1]] != MINE) {
                int mine = countMine(board, click);
                if (mine == 0) {
                    board[click[0]][click[1]] = BLANK;
                    List<int[]> adj = adj(board, click);
                    for (int[] a : adj) {
                        if (!visited[a[0]][a[1]]) {
                            list.offer(a);
                        }
                    }
                } else {
                    board[click[0]][click[1]] = (char)(mine + 48);
                }
            }
        }
    }

    private int countMine(char[][] board, int[] click) {
        int count = 0;
        for (int[] adj : adj(board,click)){
            if (board[adj[0]][adj[1]] == MINE){
                count++;
            }
        }
        return count;
    }

    public LinkedList<int[]> adj(char[][] board, int[] start) {

        int x = start[0];

        int y = start[1];


        LinkedList<int[]> list = new LinkedList<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {

                if (i != x || j != y) {
                    try {
                        char c = board[i][j];
                        list.add(new int[] {i, j});
                    } catch (IndexOutOfBoundsException ignore) {

                    }
                }
            }
        }
        return list;
    }

    public void click(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == MINE) {
            board[x][y] = X;
        } else if (board[x][y] == EMPTY) {
            board[x][y] = BLANK;
        }
    }

    public static void print(char[][] board){
        for( int i = 0 ; i < board.length ; i++){
            for ( int j = 0 ; j < board[0].length ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            { 'E','E','E','E','E'},
            { 'E','E','M','E','E'},
            { 'E','E','E','E','E'},
            { 'E','E','E','E','E'}


        };
        _529_Minesweeper.print(board);
        _529_Minesweeper q = new _529_Minesweeper();
        q.updateBoard(board,new int []{3,0});
        _529_Minesweeper.print(board);


    }


}
