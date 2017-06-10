package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/5/12 下午5:39
 */
public class _282_Game_Of_Live {


    private int live = 1;

    private int dead = 0;

    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];

        for ( int i = 0; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++) {
                copy[i][j] = board[i][j];
            }
        }


        for ( int i = 0; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++) {
                if ( copy[i][j] == live ){
                    board[i][j] = nextStateOfLive(copy,i,j);
                }else {
                    board[i][j] = nextStateOfDead(copy,i,j);
                }

            }
        }
    }


    private int nextStateOfLive(int[][] board, int x, int y ){
        List<Integer> adj = adj(board, x, y);
        long liveAdj = adj.stream().filter( s->s==live).count();
        if ( liveAdj < 2 ) {
            return dead;
        }else if ( liveAdj == 2 || liveAdj == 3 ) {
            return live;
        }else {
            return dead;
        }

    }

    private  int nextStateOfDead(int[][] board, int x,int y){
        List<Integer> adj = adj(board,x,y);
        long liveAdj = adj.stream().filter( s->s==live).count();
        if ( liveAdj == 3) {
            return live;
        }else{
            return dead;
        }

    }


    private List<Integer> adj(int[][] board, int x, int y ){
        System.out.println(String.format("source:[%d,%d]", x,y));
        List<Integer> result = new LinkedList<>();

        for( int i = x -1 ; i <= x+1; i ++ ){
            for ( int j = y - 1 ; j <= y + 1 ; j++ ) {
                System.out.println(String.format("adj:[%d,%d]", i,j));
                if ( !  (i == x && j ==y) ) {
                    try{
                        result.add(board[i][j]);
                        System.out.println(String.format("legal adj:[%d,%d]", i,j));
                    }catch (ArrayIndexOutOfBoundsException ignore){

                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        _282_Game_Of_Live g = new _282_Game_Of_Live();
        int[][] x = new int[][]{{1,1,},{1,0}};
        g.gameOfLife(x);
        System.out.println(x);

    }

}
