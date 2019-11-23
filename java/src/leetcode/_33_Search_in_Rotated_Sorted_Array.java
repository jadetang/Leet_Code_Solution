package leetcode;

/**
 * @author jade on 2017/7/1 下午5:03
 */
public class _33_Search_in_Rotated_Sorted_Array {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    return search(nums, 0, nums.length - 1, target);
  }


  //二分查找法，当 A[L] <= A[R] 的时候，表示子数组已经有序了，可以用二分查找。
  int search(int[] A, int L, int R, int target) {
    if (A[L] <= A[R]) {
      return binarySearch(A, L, R, target);
    } else {
      int mid = L + ((R - L) >> 1);
      int index = search(A, L, mid, target);
      if (index != -1) {
        return index;
      } else {
        return search(A, mid + 1, R, target);
      }

    }
  }


  int binarySearch(int[] A, int L, int R, int target) {
    while (L <= R) {
      int mid = L + ((R - L) >> 1);
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
