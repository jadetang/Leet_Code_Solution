package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanguan.tangsicheng on 2016/11/12 下午4:07
 */
public class _219_Contains_Duplicate_II {

  public boolean containsNearbyDuplicate(int[] nums, int k) {

    int left = 0, right = 0;
    Map<Integer, Integer> hash = new HashMap<>();
    while (right < nums.length) {
      if (right != left && nums[left] == nums[right]) {
        return true;
      }
      hash.put(nums[right], hash.getOrDefault(nums[right], 0) + 1);
      if (hash.getOrDefault(nums[right], 0) > 1) {
        return true;
      }
      right++;
      if (right - left > k) {
        hash.put(nums[left], hash.getOrDefault(nums[left], 0) - 1);
        left++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    _219_Contains_Duplicate_II q = new _219_Contains_Duplicate_II();
    int[] nums = new int[]{0, 1, 2, 3, 2, 5};
    // System.out.println(q.containsNearbyDuplicate(nums,1));
    System.out.println(q.containsNearbyDuplicate(nums, 3));
  }
}
