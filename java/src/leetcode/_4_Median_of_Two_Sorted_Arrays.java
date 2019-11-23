package leetcode;

/**
 * 找第 k 个数字， log（min（n,m））
 *
 * @author jade on 2017/7/1 上午9:14
 */
public class _4_Median_of_Two_Sorted_Arrays {


  public static void main(String[] args) {
    _4_Median_of_Two_Sorted_Arrays q = new _4_Median_of_Two_Sorted_Arrays();
    int[] a = new int[]{1, 3};
    int[] b = new int[]{2147483646, 2147483647};
    q.findMedianSortedArrays2(a, b);
  }

  public static int findkth(int[] a, int aStart, int[] b, int bStart, int k) {
    if (aStart >= a.length) {
      return b[bStart + k - 1];
    }
    if (bStart >= b.length) {
      return a[aStart + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aStart], b[bStart]);
    }
    int aMid = aStart + k / 2 - 1 < a.length ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
    int bMid = bStart + k / 2 - 1 < b.length ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;
    if (aMid < bMid) {
      return findkth(a, aStart + k / 2, b, bStart, k - k / 2);
    } else {
      return findkth(a, aStart, b, bStart + k / 2, k - k / 2);
    }
  }

  private double median(int[] A) {
    if (A == null || A.length == 0) {
      return 0.0D;
    } else {
      if (A.length % 2 == 0) {
        return (double) (A[A.length / 2 - 1] + A[A.length / 2]);
      } else {
        return (double) (A[A.length / 2 - 1]);
      }
    }
  }

  public double findMedianSortedArrays2(int[] A, int[] B) {

    if (A == null || A.length == 0) {
      return median(B);
    }
    if (B == null || B.length == 0) {
      return median(A);
    }

    if (B.length < A.length) {
      return findMedianSortedArrays2(B, A);
    }
    int x = A.length;
    int y = B.length;
    int low = 0;
    int high = x;
    while (low <= high) {
      int partionx = (low + high) / 2;
      int partiony = (x + y + 1) / 2 - partionx;
      int maxLeftx = partionx == 0 ? Integer.MIN_VALUE : A[partionx - 1];
      int minRightx = partionx == x ? Integer.MAX_VALUE : A[partionx];
      int maxLefty = partiony == 0 ? Integer.MIN_VALUE : B[partiony - 1];
      int minRighty = partiony == y ? Integer.MAX_VALUE : B[partiony];
      if (maxLeftx <= minRighty && maxLefty <= minRightx) {
        if ((x + y) % 2 == 0) {
          return
              (double) ((long) Math.max(maxLeftx, maxLefty) + (long) Math.min(minRightx, minRighty))
                  / 2;
        } else {
          return (double) (Math.max(maxLeftx, maxLefty));
        }
      } else if (maxLeftx > minRighty) {
        high = partionx - 1;
      } else {
        low = partionx + 1;
      }
    }
    throw new IllegalArgumentException();
  }

  public double findMedianSortedArrays(int A[], int B[]) {
    int length = A.length + B.length;
    if (length % 2 == 1) {
      return findkth(A, 0, B, 0, length / 2 + 1);
    } else {
      return (findkth(A, 0, B, 0, length / 2) + findkth(A, 0, B, 0, length / 2 + 1)) * 0.5;
    }
  }


}
