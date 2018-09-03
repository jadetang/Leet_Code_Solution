package solution;

import level.Easy;

/**
 * @author jade on 16/9/12 下午3:48
 */
public class _26_Remove_Duplicates_from_Sorted_Array implements Easy {

  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return 1;
    } else {
      int i = 0;
      //两个指针，如果 快慢不一样，则 慢++，快++
      //否则快++；效率是 on
      for (int j = 1; j < nums.length; j++) {
        if (nums[i] != nums[j]) {
          i++;
          nums[i] = nums[j];
        }
      }
      return i + 1;
    }
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 2, 3};
    removeDuplicates(a);
  }
}
