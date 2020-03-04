package leetcode;

import org.junit.Test;
import util.Assert;

/**
 * @author jade on 2016/12/8 下午10:27
 */
public class _410_Split_Array_Largest_Sum {

  @Test
  public void test() {
    _410_Split_Array_Largest_Sum q = new _410_Split_Array_Largest_Sum();
    Assert.assertEqual(18, q.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
  }

  public int splitArray(int[] nums, int m) {
    int sum = 0;
    int max = 0;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int l = max;
    int r = sum;
    while (l < r) {
      int mid = (r + l) >>> 1;
      if (count(nums, mid) <= m) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  int count(int[] array, int arraySum) {
    int count = 1;
    int sum = 0;
    for (int i : array) {
      if (i + sum > arraySum) {
        count++;
        sum = i;
      }else {
        sum += i;
      }
    }
    return count;
  }

  private boolean valid(long target, int[] nums, int m) {
    int count = 1;
    long sum = 0L;
    for (int num : nums) {
      sum += num;
      if (sum > target) {
        sum = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }
}
