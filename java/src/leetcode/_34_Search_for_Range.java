package leetcode;

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

  public int[] searchRange2(int[] nums, int target) {
    int lowerBound = lowerBound(nums, target);
    int upperBound = upperBound(nums, target);
    return new int[]{lowerBound, upperBound - 1};
  }

  public int upperBound(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] > target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  public int lowerBound(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] >= target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
