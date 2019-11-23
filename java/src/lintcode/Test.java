package lintcode;

import java.util.Arrays;

public class Test {

  static int[] spiralCopy(int[][] inputMatrix) {
    int n = inputMatrix.length;
    int m = inputMatrix[0].length;
    int[] result = new int[n * m];

    int[] step = new int[1];
    int[] p = new int[]{0, 0};
    while (step[0] < n * m) {

      //[0,4]
      p = copy(p, inputMatrix, result, "right", step);
      if (step[0] >= n * m) {
        continue;
      }

      p = nextPosition(p, "down");
      p = copy(p, inputMatrix, result, "down", step);
      if (step[0] >= n * m) {
        continue;
      }
      p = nextPosition(p, "left");
      p = copy(p, inputMatrix, result, "left", step);
      if (step[0] >= n * m) {
        continue;
      }
      p = nextPosition(p, "up");
      p = copy(p, inputMatrix, result, "up", step);
      if (step[0] >= n * m) {
        continue;
      }
      p = nextPosition(p, "right");

    }

    return result;

    // your code goes here
  }

  private static int[] copy(int[] startp, int[][] matrix, int[] des, String direction, int[] step) {

    int[] curP = startp;

    des[step[0]++] = matrix[curP[0]][curP[1]];
    matrix[curP[0]][curP[1]] = -1;
    int[] nextP = nextPosition(startp, direction);

    while (validNextP(nextP, matrix)) {

      curP = nextP;

      des[step[0]++] = matrix[curP[0]][curP[1]];
      matrix[curP[0]][curP[1]] = -1;

      nextP = nextPosition(curP, direction);

    }
    return curP;
  }


  private static boolean validNextP(int[] p, int[][] matrix) {
    int i = p[0];
    int j = p[1];

    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == -1) {
      return false;
    }
    return true;


  }

  private static int[] nextPosition(int[] curP, String dir) {

    int i = curP[0];

    int j = curP[1];

    switch (dir) {
      case "right":
        return new int[]{i, j + 1};
      case "left":
        return new int[]{i, j - 1};
      case "down":
        return new int[]{i + 1, j};
      case "up":
        return new int[]{i - 1, j};
    }

    return new int[]{};

  }


  public static void main(String[] args) {
    int[][] a = new int[][]{{1, 2, 3, 4}, {4, 5, 6, 10}, {1, 7, 8, 9}};
    int[] res = spiralCopy(a);
    System.out.println(Arrays.toString(res));
  }

}
