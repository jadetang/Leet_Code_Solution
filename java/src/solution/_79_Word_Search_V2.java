package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sanguan.tangsicheng on 2017/7/2 上午8:21
 */
public class _79_Word_Search_V2 {

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; x < board[0].length; y++) {
                Set<Integer> set = new HashSet<>();
                if (exist(set, board, x, y, w, 0)) { return true; }
            }
        }
        return false;
    }

    private static boolean exist(Set<Integer> set, char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) { return true; }
        if (y < 0 || x < 0 || x >= board.length || y >= board[0].length) { return false; }

        if (set.contains(board[0].length * x + y)) {
            return false;
        } else {
            set.add(board[0].length * x + y);
        }


        if (board[x][y] != word[i]) { return false; }
        boolean res = exist(set, board, x, y + 1, word, i + 1)
            || exist(set, board, x, y - 1, word, i + 1)
            || exist(set, board, x + 1, y, word, i + 1)
            || exist(set, board, x - 1, y, word, i + 1);
        set.remove(board[0].length * x + y);
        return res;

    }

    public static void main(String[] args) {
        char[][] b = new char[][] {{'a', 'b'}, {'c', 'd'}};
        boolean rest = exist(b, "acbd");
        System.out.println("1"+rest);
    }

}
