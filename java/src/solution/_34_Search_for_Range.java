package solution;

import java.util.Arrays;

/**
 * @author jade on 2017/7/1 下午5:11
 */
public class _34_Search_for_Range {

  //二分查找，然后向中间和两变扩展

  public int[] searchRange(int[] nums, int target) {

    int index = Arrays.binarySearch(nums, target);

    if (index < 0) {
      return new int[]{-1, -1};
    } else {

      int start = index;
      int end = index;
      while (start >= 0 && nums[start] == target) {
        start--;
      }
      start++;
      while (end < nums.length && nums[end] == target) {
        end++;
      }
      end--;
      return new int[]{start, end};

    }


  }
}
