package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/12 下午5:39
 */
public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        for( int i = 0 ; i < 9 ; i++){
            if ( ! validRow( board[i] ) ){
                return false;
            }
            if( ! validColumn(board,i)){
                return false;
            }
            if( ! validArea(board,i)){
                return false;
            }
        }
        return true;
    }

    private boolean validArea(char[][] board,int num){
        int[] hash = new int[9];
        int rowOffset = 3* (num / 3 );
        int colOffset = 3 * (num % 3);
        for( int i = 0 ; i < 3 ; i++ ){
            for( int j = 0; j < 3; j++){
                if(board[rowOffset+i][colOffset+j] == '.') continue;
                if(hash[board[rowOffset+i][colOffset+j] - '0'] > 0 ){
                    return false;
                }else{
                    hash[board[rowOffset+i][colOffset+j] - '0']++;
                }
            }
        }
        return true;
    }



    private boolean validRow(char[] row){
        int[] hash = new int[9];
        for( int i = 0; i< 9 ; i++){
            if (row[i] == '.') continue;
            if(hash[row[i] - '0'] > 0 ){
                return false;
            }else{
                hash[row[i] - '0']++;
            }
        }
        return true;
    }

    private boolean validColumn(char[][] board,int column){
        int[] hash = new int[9];
        for( int i = 0; i<9 ;i++){
            if( board[i][column] == '.') continue;
            if(hash[board[i][column] -'0'] > 0){
                return false;
            }else{
                hash[board[i][column] -'0']++;
            }
        }
        return true;
    }

}
