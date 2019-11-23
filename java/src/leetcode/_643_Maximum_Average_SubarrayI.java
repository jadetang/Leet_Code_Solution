package leetcode;

import org.junit.Assert;

/**
 * @author jade on 2017/7/16 上午9:38
 */
public class _643_Maximum_Average_SubarrayI {


  public static double findMaxAverage(int[] nums, int k) {

    int sum = 0;

    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }

    double avg = sum / (double) k;

    for (int i = k; i < nums.length; i++) {

      sum += nums[i];

      sum -= nums[i - k];

      avg = Math.max(avg, sum / (double) k);


    }

    return avg;

  }

  public static void main(String[] args) {
    int[] arrary = new int[]{1, 12, -5, -6, 50, 3};
    double ans = findMaxAverage(arrary, 4);

    Assert.assertEquals(12.75, ans, 0.00);

  }


}
