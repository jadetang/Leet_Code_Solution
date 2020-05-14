package leetcode;

public class _1060_Missing_Element_in_Sorted_Array {

  int missing(int[] nums, int index) {
    return nums[index] - nums[0] - index;
  }

  public int missingElement(int[] nums, int k) {
    int miss = missing(nums, nums.length - 1);
    if (k > miss) {
      return nums[nums.length - 1] + (k - miss);
    }
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      miss = missing(nums, mid);
      if (miss >= k) {
        r = mid;
      }else {
        l = mid + 1;
      }
    }
    return nums[l - 1] + k - missing(nums, l - 1);
  }

}