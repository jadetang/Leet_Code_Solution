package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/13 下午2:42
 */
public class _413_Arithmetic_Slices {

  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    } else if (A.length == 1) {
      return 1;
    } else {
      int count = 0;
      int left = 0, right = 1;
      int diff = A[right] - A[left];
      while (right < A.length) {
        if (right < A.length - 1 && A[right + 1] - A[right] == diff) {
          right++;
        } else {
          int length = right - left + 1;
          if (length >= 3) {
            count += ((1 + (length - 2)) * (length - 2)) / 2;
          }
          if (right == A.length - 1) {
            break;
          } else {
            left = right;
            right++;
            diff = A[right] - A[left];
          }
        }

      }
      return count;
    }
  }

  public static void main(String[] args) {
    _413_Arithmetic_Slices q = new _413_Arithmetic_Slices();
    int[] a = new int[]{1, 3, 5, 7, 9};
    int[] b = new int[]{1, 2, 3, 4, 1, 3, 5, 7, 9};
    int[] c = new int[]{1, 1, 1, 1, 1};
    System.out.println(q.numberOfArithmeticSlices(a));
    System.out.println(q.numberOfArithmeticSlices(b));
    System.out.println(q.numberOfArithmeticSlices(c));

  }


}
