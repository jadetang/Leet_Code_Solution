package lintcode;

import java.util.Arrays;
import util.Assert;

public class _1623_Minimal_Distance_In_The_Array {


  public static void main(String[] args) {
    _1623_Minimal_Distance_In_The_Array q = new _1623_Minimal_Distance_In_The_Array();
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 8};
    Assert.assertEqual(6, q.findCloset(a, 7));
    Assert.assertEqual(1, q.findCloset(a, 1));
    Assert.assertEqual(1, q.findCloset(a, 0));
    Assert.assertEqual(8, q.findCloset(a, 10));
  }

  public int[] minimalDistance(int[] a, int[] b) {
    int[] result = new int[b.length];
    Arrays.sort(a);
    for (int i = 0; i < b.length; i++) {
      result[i] = findCloset(a, b[i]);
    }
    return result;
    // Write your code here
  }

  private int findCloset(int[] array, int target) {
    int index = Arrays.binarySearch(array, target);
    if (index >= 0) {
      return array[index];
    } else {
      int insertPoint = -index - 1;
      if (insertPoint == 0) {
        return array[0];
      } else if (insertPoint == array.length) {
        return array[array.length - 1];
      } else {
        int left = Math.abs(target - array[insertPoint - 1]);
        int right = Math.abs(target - array[insertPoint]);
        if (right < left) {
          return array[insertPoint];
        } else {
          return array[insertPoint - 1];
        }
      }
    }
  }

}
