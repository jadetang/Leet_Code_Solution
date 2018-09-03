package solution;

/**
 * @author jade on 2017/5/12 下午8:04
 */
public class _80_Remove_Duplicates_from_Sorted_Array_II {


  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    } else {
      int k = 0;
      for (int i = 0, j = 1; i < nums.length; i = j++) {

        while (j < nums.length && nums[j] == nums[i]) {
          j++;
        }
        nums[k++] = nums[i];
        if (j - i >= 2) {
          nums[k++] = nums[i];
        }
      }
      return Math.min(k, nums.length);
    }
  }


  public static void main(String[] args) {
    int[] x = new int[]{1, 1, 2};
    _80_Remove_Duplicates_from_Sorted_Array_II q = new _80_Remove_Duplicates_from_Sorted_Array_II();
    int k = q.removeDuplicates(x);
    System.out.println(k);
    for (int i = 0; i < x.length; i++) {
      System.out.println(x[i]);
    }
  }
}
