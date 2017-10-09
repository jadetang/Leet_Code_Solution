package other;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午5:55
 */
public class BinarySearch {

  int binarySearch(int[] A, int L, int R, int target) {
    while (L <= R) {
      //int mid = L + ((R - L) >> 1);
      int mid = (R + L) >>> 1;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    return -1;
  }
}
