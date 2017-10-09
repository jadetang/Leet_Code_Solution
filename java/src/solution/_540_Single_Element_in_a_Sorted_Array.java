package solution;

import util.Assert;

/**
 * @author sanguan.tangsicheng on 2017/7/30 下午6:02
 */
public class _540_Single_Element_in_a_Sorted_Array {

  public static int singleNonDuplicate(int[] array) {
    int start = 0, end = array.length - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (mid % 2 == 1) {
        mid--;
      }
      if (array[mid] == array[mid + 1]) {
        start = mid + 2;
      } else {
        end = mid;
      }
    }
    return array[start];
  }


  public static int singleNonDuplicate2(int[] nums) {
    int start = 0, end = nums.length - 1;

    while (start < end) {
      // We want the first element of the middle pair,
      // which should be at an even index if the left part is sorted.
      // Example:
      // Index: 0 1 2 3 4 5 6
      // Array: 1 1 3 3 4 8 8
      //            ^
      int mid = (start + end) / 2;
      if (mid % 2 == 1) {
        mid--;
      }

      // We didn't find a pair. The single element must be on the left.
      // (pipes mean start & end)
      // Example: |0 1 1 3 3 6 6|
      //               ^ ^
      // Next:    |0 1 1|3 3 6 6
      if (nums[mid] != nums[mid + 1]) {
        end = mid;
      }

      // We found a pair. The single element must be on the right.
      // Example: |1 1 3 3 5 6 6|
      //               ^ ^
      // Next:     1 1 3 3|5 6 6|
      else {
        start = mid + 2;
      }
    }

    // 'start' should always be at the beginning of a pair.
    // When 'start > end', start must be the single element.
    return nums[start];
  }


  public static void main(String[] args) {
    int[] array1 = new int[]{1, 2, 2};
    Assert.assertEqual(1, singleNonDuplicate(array1));

    int[] array2 = new int[]{1, 2, 2, 3, 3};
    Assert.assertEqual(1, singleNonDuplicate(array2));

    int[] array3 = new int[]{2, 2, 3, 3, 4};
    Assert.assertEqual(4, singleNonDuplicate(array3));

    int[] array4 = new int[]{1, 1, 2, 3, 3};
    Assert.assertEqual(2, singleNonDuplicate(array4));

    int[] array5 = new int[]{0, 1, 1, 2, 2, 5, 5};
    Assert.assertEqual(0, singleNonDuplicate(array5));
  }


}
