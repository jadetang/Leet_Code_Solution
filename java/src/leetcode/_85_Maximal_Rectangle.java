package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Test;
import util.Assert;

/**
 * @author jade on 2017/6/10 下午4:45
 */
public class _85_Maximal_Rectangle {

  @Test
  public void test() {
    _85_Maximal_Rectangle max = new _85_Maximal_Rectangle();
    char[][] matrix = new char[][] {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
    };
    Assert.assertEqual(6, max.maximalRectangle(matrix));
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int[][] width = new int[matrix.length][matrix[0].length];
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          width[i][j] = 0;
        } else {
          if (j == 0) {
            width[i][j] = 1;
          } else {
            width[i][j] = width[i][j - 1] + 1;
          }
          int tempWidth = Integer.MAX_VALUE;
          for (int k = i; k >= 0 && width[k][j] > 0; k--) {
            tempWidth = Math.min(tempWidth, width[k][j]);
            ans = Math.max(ans, tempWidth * (i - k + 1));
          }
        }
      }
    }
    return ans;
  }
}
