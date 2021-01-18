package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array {

    @Test
    public void test() {
        _1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array q = new _1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array();
        Assert.assertTrue(q.isMajorityElement(new int[] {2,4,5,5,5,5,5,6,6}, 5));
        Assert.assertFalse(q.isMajorityElement(new int[] {1, 2, 3}, 5));
    }

    public boolean isMajorityElement(int[] nums, int target) {
        return findMajority(nums) == target;
    }

    private int findMajority(int[] nums) {
        int l = 0;
        int r = (nums.length - 1) / 2;
        while (true) {
            if (nums[l] == nums[r]) {
                return nums[l];
            } else {
                l = findFirst(nums, l, r, nums[r]);
                r = l + (nums.length - 1) / 2 - 1;
                if (r >= nums.length) {
                    break;
                }
            }
        }
        return -1;
    }

    private int findFirst(int[] nums, int l, int r, int num) {
        r++;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= num) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
