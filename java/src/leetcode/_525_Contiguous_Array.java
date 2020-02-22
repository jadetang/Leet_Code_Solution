package leetcode;

import org.junit.Test;
import util.Assert;

public class _525_Contiguous_Array {

    @Test
    public void test() {
        int[] nums = new int[] {0,1,1,0};
        _525_Contiguous_Array q = new _525_Contiguous_Array();
        Assert.assertEqual(4, q.findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] presum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;
        }
        int l = nums.length % 2 == 0 ? nums.length : nums.length - 1;
        for (; l >= 2; l-=2) {
            for (int i = 0; i + l <= nums.length; i++) {
                if (presum[i + l] - presum[i] == l / 2 ) {
                   return l;
                }
            }
        }
        return 0;
    }

}
