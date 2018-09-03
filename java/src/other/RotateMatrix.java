package other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2 Given a 2D NxN matrix, visualize it as concentric circles. You have to find the rotated matrix
 * where each element in the circle is rotated by 1 position layer by layer in an alternate
 * clockwise and anticlockwise direction. All rotations should be in-place. <p> 2 3 4 5 1 6 7 8 4 2
 * 1 9 5 3 2 4 should get transformed to <p> 1 2 3 4 4 7 1 5 5 6 2 8 3 2 4 9
 *
 * @author jade on 2016/11/24 下午1:15
 */
public class RotateMatrix {

  public static void main(String[] args) {
    RotateMatrix r = new RotateMatrix();
    int[][] matrix = new int[][]{{34, 11, 20, 16},
        {10, 3, 5, 7},
        {11, 23, 30, 50}};
    RotateMatrix.printMatrix(matrix);
    sortMatrix(matrix);
    System.out.println("-------");
    RotateMatrix.printMatrix(matrix);
  }

  public int[][] rotate(int[][] matrix) {

    for (int i = 0; i < matrix.length / 2; i++) {
      System.out.println("------------");
      rotateLine(matrix, i);
    }
    return matrix;


  }

  private void rotateLine(int[][] matrix, int depth) {
    int n = matrix.length - 1;
    int rightUpper = matrix[depth][n - depth];
    int leftDown = matrix[n - depth][depth];
    int rightDown = matrix[n - depth][n - depth];

    //uppper line
    for (int i = n - depth; i >= depth + 1; i--) {
      matrix[depth][i] = matrix[depth][i - 1];
    }
    System.out.println("after upper line");
    printMatrix(matrix);
    //right column
    for (int i = n - depth; i >= depth + 2; i--) {
      matrix[i][n - depth] = matrix[i - 1][n - depth];
    }
    matrix[depth + 1][n - depth] = rightUpper;
    System.out.println("after right column:");
    printMatrix(matrix);
    //down line
    for (int i = depth; i <= n - depth - 2; i++) {
      matrix[n - depth][i] = matrix[n - depth][i + 1];
    }
    matrix[n - depth][n - depth - 1] = rightDown;
    System.out.println("after down line");
    printMatrix(matrix);
    //left column
    for (int i = depth; i <= n - depth - 2; i++) {
      matrix[i][depth] = matrix[i + 1][depth];
    }
    matrix[n - depth - 1][depth] = leftDown;
    System.out.println("after left column");
    printMatrix(matrix);
  }


  public static void printMatrix(int[][] matrix) {
    for (int[] line : matrix) {
      for (int i : line) {
        System.out.print(i + ",");
      }
      System.out.println("\n");
    }
  }

  public static int[][] sortMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      Arrays.sort(row);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    for (int i = 0; i < matrix.length; i++) {
      queue.add(matrix[i][0]);
    }
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = queue.poll();
    }
    for (int[] row : matrix) {
      Arrays.sort(row);
    }
    return matrix;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static void adjust(int[] array) {
    int firstNumber = array[0];
    int index = Arrays.binarySearch(array, 1, array.length, firstNumber);
    index = index < 0 ? -(index) - 2 : index - 1;
    swap(array, 0, index);
  }

}
