package leetcode;


import java.util.List;
import org.junit.Test;

public class _1253_Reconstruct_a_2Row_Binary_MatrixTest {

  _1253_Reconstruct_a_2Row_Binary_Matrix solution = new _1253_Reconstruct_a_2Row_Binary_Matrix();

  @Test
  public void reconstructMatrix() {
    int upper = 4;
    int lower = 14;
    int[] array = new int[]{0, 2, 1, 2, 1, 2, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 2, 1, 2};
    List<List<Integer>> res = solution.reconstructMatrix(upper, lower, array);
    System.out.println(res);
  }
}