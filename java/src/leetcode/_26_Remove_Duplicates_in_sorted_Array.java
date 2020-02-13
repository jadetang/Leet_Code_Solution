package leetcode;

public class _26_Remove_Duplicates_in_sorted_Array {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i++;
            }
            swap(nums,i++,j++);
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
