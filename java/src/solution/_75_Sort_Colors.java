package solution;

import level.Medium;
import tag.Array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * @author jade on 2017/5/4 下午10:07
 */
public class _75_Sort_Colors implements Array, Medium {

  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length - 1;
    int oneIndex = 0;
    while (oneIndex <= twoIndex) {
      if (nums[oneIndex] == 1) {
        oneIndex++;
      } else if (nums[oneIndex] < 1) {
        swap(nums, zeroIndex++, oneIndex++);
      } else {
        swap(nums, oneIndex, twoIndex--);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  // two pass O(m+n) space, 计算出来
  void sortColors1(int A[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;

    for (int i = 0; i < n; i++) {
      if (A[i] == 0) {
        ++num0;
      } else if (A[i] == 1) {
        ++num1;
      } else if (A[i] == 2) {
        ++num2;
      }
    }

    for (int i = 0; i < num0; ++i) {
      A[i] = 0;
    }
    for (int i = 0; i < num1; ++i) {
      A[num0 + i] = 1;
    }
    for (int i = 0; i < num2; ++i) {
      A[num0 + num1 + i] = 2;
    }
  }

  // one pass in place solution
  void sortColors2(int A[], int n) {
    int n0 = -1, n1 = -1, n2 = -1;
    for (int i = 0; i < n; ++i) {
      if (A[i] == 0) {
        A[++n2] = 2;
        A[++n1] = 1;
        A[++n0] = 0;
      } else if (A[i] == 1) {
        A[++n2] = 2;
        A[++n1] = 1;
      } else if (A[i] == 2) {
        A[++n2] = 2;
      }
    }
  }

  // one pass in place solution
  void sortColors3(int A[], int n) {
    int j = 0, k = n - 1;
    for (int i = 0; i <= k; ++i) {
      if (A[i] == 0 && i != j) {
        swap(A, A[i--], A[j++]);
      } else if (A[i] == 2 && i != k) {
        swap(A, A[i--], A[k--]);
      }
    }
  }

  // one pass in place solution
  void sortColors4(int A[], int n) {
    int j = 0, k = n - 1;
    for (int i = 0; i <= k; i++) {
      if (A[i] == 0) {
        swap(A, A[i], A[j++]);
      } else if (A[i] == 2) {
        swap(A, A[i--], A[k--]);
      }
    }
  }
}
