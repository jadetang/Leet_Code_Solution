package solution;

/**
 * @author jade on 2016/12/8 下午10:27
 */
public class _410_Split_Array_Largest_Sum {

  public int splitArray(int[] nums, int m) {
    long sum = 0L;
    long max = 0L;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    long l = max;
    long r = sum;
    while (l <= r) {
      long mid = (r + l) >>> 1;
      if (valid(mid, nums, m)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return (int) l;
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

  public static void main(String[] args) {
    _410_Split_Array_Largest_Sum q = new _410_Split_Array_Largest_Sum();
    System.out.println(q.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
  }
}
