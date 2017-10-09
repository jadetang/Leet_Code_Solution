package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sanguan.tangsicheng on 2017/6/10 下午4:45
 */
public class _85_Maximal_Rectangle {

  public int maximalRectangle(char[][] matrix) {
    int max = 0;
    if (matrix.length == 0) {
      return 0;
    }
    int[] preHeight = null;
    for (int i = 0; i < matrix.length; i++) {

      int[] curHeight = update(preHeight, convert(matrix[i]));
      max = Math.max(max, maxRectangle(curHeight));
    }
    return max;
  }

  private int[] convert(char[] array) {

    int[] result = new int[array.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = array[i] - 48;
    }
    return result;
  }

  private int maxRectangle(int[] height) {

    Deque<Integer> stack = new ArrayDeque<>();

    int len = height.length;
    int max = 0;
    for (int i = 0; i < len; ) {
      if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
        stack.push(i++);
      } else {
        int h = stack.pop();
        max = Math.max(max, height[h] * (stack.isEmpty() ? i : h - stack.peek() - 1));

      }

    }
    while (!stack.isEmpty()) {
      int h = stack.pop();
      max = Math.max(max, height[h] * (stack.isEmpty() ? len : len - stack.peek() - 1));

    }
    return max;

  }

  public int[] update(int[] preHeight, int[] curHeight) {
    if (preHeight == null) {
      return curHeight;
    } else {
      int[] result = new int[curHeight.length];
      for (int i = 0; i < preHeight.length; i++) {
        if (curHeight[i] != '0' && preHeight[i] != 0) {
          result[i] = curHeight[i] - 48 + preHeight[i];
        } else {
          result[i] = curHeight[i] - 48;
        }
      }
      return result;
    }
  }

  public static void main(String[] args) {
    _85_Maximal_Rectangle q = new _85_Maximal_Rectangle();
    char[][] matrix = new char[][]{"10100".toCharArray(), "10111".toCharArray(),
        "11111".toCharArray(),
        "10010".toCharArray()};
    q.maximalRectangle(matrix);
  }
}
