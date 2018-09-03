package solution;

import java.util.HashMap;
import java.util.Map;
import level.Easy;

/**
 * @author jade on 2017/7/1 上午8:38
 */
public class _1_2Sum implements Easy {


  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> dict = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      dict.put(nums[i], i);
    }
    System.out.println(dict);
    for (int i = 0; i < nums.length; i++) {
      if (dict.containsKey(target - nums[i])) {
        return new int[]{i, dict.get(target - nums[i])};
      }
    }
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 4};
    twoSum(nums, 6);
  }

}
