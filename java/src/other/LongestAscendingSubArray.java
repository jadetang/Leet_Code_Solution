package other;


/**
 * Write a function that, given a zero-indexed array A consisting of N integers, returns the
 * beginning of any ascending slice of A of maximal size.
 */
public class LongestAscendingSubArray {

  public static int longestAscendingSubArray(int[] array) {
    if (array == null || array.length == 0) {
      return -1;
    }
    if (array.length == 1) {
      return 0;
    } else {
      int i = 0;
      int j = 0;
      int max = Integer.MIN_VALUE;
      int result = -1;
      while (j < array.length) {
        while (j < array.length && array[i] <= array[j]) {
          j++;
        }
        if (j - i + 1 > max) {
          max = j - i + 1;
          result = i;
        }
        i = j;
        j++;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    int[] arrary = new int[]{2, 3, 4, 1, 5, 6, 7, 8};
    int[] arrary2 = new int[]{4, 3, 2, 1};
    int[] arrary3 = new int[]{4};
    int[] arrary4 = new int[]{};
    int[] arrary5 = new int[]{1, 5, 6, 7, 8};
    System.out.println(longestAscendingSubArray(arrary));
    System.out.println(longestAscendingSubArray(arrary2));
    System.out.println(longestAscendingSubArray(arrary3));
    System.out.println(longestAscendingSubArray(arrary4));
    System.out.println(longestAscendingSubArray(arrary5));
  }

}
