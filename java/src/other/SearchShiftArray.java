package other;

import java.util.Arrays;

public class SearchShiftArray {


  private static int findSplittingPoint(int[] arr) {
    int start = 0;
    int end = arr.length - 1;    //  [0, arr.length-1]
    while (start <= end) {
      int i = (end + start) / 2;
      if (arr[i] > arr[i + 1]) {
        return i;
      }
      if (arr[i] > arr[0]) {
        start = i + 1;
      } else {
        end = i - 1;
      }
    }
    return -1;
  }

  //-insertIndex-1
  static int shiftedArrSearch(int[] shiftArr, int num) {
    int split = findSplittingPoint(shiftArr);
    System.out.println(split);
    int pos = Arrays.binarySearch(shiftArr, 0, split + 1, num);
    if (pos > 0) {
      return pos;
    }
    pos = Arrays.binarySearch(shiftArr, split + 1, shiftArr.length, num);
    return pos > 0 ? pos : -1;
  }

  public static void main(String[] args) {
//    int[] arr = new int[] { 9, 2, 4 };
    int[] arr = new int[]{9, 12, 17, 2, 4, 5};
//    int[] arr = new int[] { 9, 12, 17, 22, 41,5 };
//    int[] arr = new int[] { 9, 2, 4 };
    System.out.println(shiftedArrSearch(arr, 5));
  }

}
