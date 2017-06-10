package solution;

/**
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
