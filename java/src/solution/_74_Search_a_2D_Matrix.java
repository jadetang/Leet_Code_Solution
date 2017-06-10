package solution;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * @author sanguan.tangsicheng on 2017/5/21 下午3:48
 */
public class _74_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } else {
            int[] array = new int[matrix.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = matrix[i][0];
            }
            int index = Arrays.binarySearch(array, target);
            if (index >= 0) {
                return true;
            } else {
                if (index == -1) {
                    index = 0;
                } else {
                    index = -index - 2;
                }
                return Arrays.binarySearch(matrix[index], target) >= 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        _74_Search_a_2D_Matrix q = new _74_Search_a_2D_Matrix();
        System.out.println(q.searchMatrix(matrix, 3));
        System.out.println(q.searchMatrix(matrix, 4));
        System.out.println(q.searchMatrix(matrix, 8));
    }

}
