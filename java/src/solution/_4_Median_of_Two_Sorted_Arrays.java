package solution;

/**
 * 找第 k 个数字， log（min（n,m））
 *
 * @author sanguan.tangsicheng on 2017/7/1 上午9:14
 */
public class _4_Median_of_Two_Sorted_Arrays {


  public double findMedianSortedArrays(int A[], int B[]) {
    int length = A.length + B.length;
    if (length % 2 == 1) {
      return findkth(A, 0, B, 0, length / 2 + 1);
    } else {
      return (findkth(A, 0, B, 0, length / 2) + findkth(A, 0, B, 0, length / 2 + 1)) * 0.5;
    }
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

  public static void main(String[] args) {
    long a = 10L;
    long[] l = new long[(int) a];
  }

}
