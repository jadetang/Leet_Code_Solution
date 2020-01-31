package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _34_Search_for_RangeTest {

  _34_Search_for_Range solution = new _34_Search_for_Range();

  int[] array = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7};

  @Test
  public void upperBound() {
    assertEquals(array.length, solution.upperBound(array, 7));
    assertEquals(array.length - 1, solution.upperBound(array, 6));
    assertEquals(1, solution.upperBound(array, 1));
    assertEquals(0, solution.upperBound(array, -1));
  }

  @Test
  public void lowerBound() {
    assertEquals(array.length - 1, solution.lowerBound(array, 7));
    assertEquals(array.length - 2, solution.lowerBound(array, 6));
    assertEquals(0, solution.lowerBound(array, 1));
    assertEquals(0, solution.lowerBound(array, -1));
  }
}