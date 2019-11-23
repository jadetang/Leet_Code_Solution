package company.facebook;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Largest_sum_subarray_with_at_least_k_numbersTest {

  @Test
  public void largestSum() {
    int[] array = new int[]{1, 2, 5, 6, 7};
    assertEquals(13, Largest_sum_subarray_with_at_least_k_numbers.largestSum(array, 2));
  }

  @Test
  public void largestSum2() {
    int[] array = new int[]{-4, -2, 1, -3};
    assertEquals(-1, Largest_sum_subarray_with_at_least_k_numbers.largestSum(array, 2));
  }
}