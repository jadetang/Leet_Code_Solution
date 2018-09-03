package solution;

import java.util.TreeMap;

/**
 * @author jade on 2017/5/4 下午4:57
 */
public class _209_Minimum_Size_Subarray_Sum {

  // nlog(n) but tle
  public int minSubArrayLen(int k, int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1 && nums[0] == k) {
      return 1;
    }
    int range = Integer.MAX_VALUE;
    TreeMap<Integer, Integer> map = new TreeMap<>();  //sum, rightMostIndex

    int sum = 0;
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.floorKey(sum - k) != null) {
        range = Math.min(range, i - map.floorEntry(sum - k).getValue());
      }
      if (map.containsKey(sum)) {
        map.put(sum, Math.max(map.get(sum), i));
      } else {
        map.put(sum, i);
      }
    }
    return range == Integer.MAX_VALUE ? 0 : range;
  }

  // O(n2)
  public int minSubArrayLen2(int k, int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return k >= nums[0] ? 1 : 0;
    }

    int[] suffix = buildSuffix(nums);
    int range = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (suffix[i] >= k) {
        range = Math.min(range, i + 1);
      }
      for (int j = i - 1; j >= 0 && (i - j) < range; j--) {
        if (suffix[i] - suffix[j] >= k) {
          range = Math.min(range, i - j);
        }
      }
    }
    return range;
  }

  int[] buildSuffix(int[] nums) {
    int sum = 0;
    int[] suffix = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      suffix[i] = sum;
    }
    return suffix;

  }

  public static void main(String[] args) {
    _209_Minimum_Size_Subarray_Sum q = new _209_Minimum_Size_Subarray_Sum();
    int[] nums = new int[]{1, 2, 3, 5};
    int k = q.minSubArrayLen(8, nums);
    System.out.println(k);
    k = q.minSubArrayLen2(8, nums);
    System.out.println(k);
  }

}