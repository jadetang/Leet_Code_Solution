package solution;

/**
 * clockwise rotate first reverse up to down, then swap the symmetry 1 2 3     7 8 9     7 4 1 4 5 6
 * => 4 5 6  => 8 5 2 7 8 9     1 2 3     9 6 3
 *
 * void rotate(vector<vector<int> > &matrix) { reverse(matrix.begin(), matrix.end()); for (int i =
 * 0; i < matrix.size(); ++i) { for (int j = i + 1; j < matrix[i].size(); ++j) swap(matrix[i][j],
 * matrix[j][i]); } }
 *
 *
 * anticlockwise rotate first reverse left to right, then swap the symmetry 1 2 3     3 2 1     3 6
 * 9 4 5 6  => 6 5 4  => 2 5 8 7 8 9     9 8 7     1 4 7
 *
 * void anti_rotate(vector<vector<int> > &matrix) { for (auto vi : matrix) reverse(vi.begin(),
 * vi.end()); for (int i = 0; i < matrix.size(); ++i) { for (int j = i + 1; j < matrix[i].size();
 * ++j) swap(matrix[i][j], matrix[j][i]); } }
 *
 * @author sanguan.tangsicheng on 2017/5/6 下午12:56
 */
public class _48_Rotate_Image {

  public int[][] rotate(int[][] matrix) {

    for (int i = 0; i < matrix.length / 2; i++) {
      System.out.println("------------");
      rotateLine(matrix, i);
    }
    return matrix;

  }

  public static void main(String[] args) {
    int[][] m = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
    int[][] x = rotate2(m);
    printMatrix(x);
  }

  public static int[][] rotate2(int[][] mat) {

    int N = mat.length;

    for (int x = 0; x < N / 2; x++) {
      int length = N - x;
      for (int y = x; y < length; y++) {
        int temp = mat[x][y];

        mat[x][y] = mat[N - x - 1][y];

        mat[N - x - 1][y] = mat[N - 1 - x][N - 1 - y];

        mat[N - 1 - x][N - 1 - y] = mat[x][N - 1 - y];

        mat[x][N - 1 - y] = temp;
        printMatrix(mat);
      }
    }
    return mat;

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

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
