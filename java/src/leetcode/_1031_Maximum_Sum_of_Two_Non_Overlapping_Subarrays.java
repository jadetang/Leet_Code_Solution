package leetcode;

import org.junit.Test;
import util.Assert;

public class _1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {

  @Test
  public void test() {
    int[] a = new int[] {0,6,5,2,2,5,1,9,4};
    _1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays q = new _1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays();
    Assert.assertEqual(20, q.maxSumTwoNoOverlap(a, 1, 2));
  }

  public int maxSumTwoNoOverlap(int[] a, int l, int m) {
    int[] leftMax = new int[a.length];
    int left = 0;
    int sum = 0;
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if (i - left + 1 >= l) {
        maxSum = Math.max(sum, maxSum);
        leftMax[i] = maxSum;
        sum -= a[left];
        left++;
      }
    }
    int[] rightMax = new int[a.length];
    int right = a.length - 1;
    sum = 0;
    maxSum = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      sum += a[i];
      if (right - i + 1 >= m) {
        maxSum = Math.max(sum, maxSum);
        rightMax[i] = maxSum;
        sum -= a[right];
        right--;
      }
    }
    int ans = 0;
    for (int i = l - 1; i < a.length - m; i++) {
      ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
    }
    return ans;
  }
}
