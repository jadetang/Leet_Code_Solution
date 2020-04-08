package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _487_Max_Consecutive_Ones_II {

    @Test
    public void test() {
        _487_Max_Consecutive_Ones_II q = new _487_Max_Consecutive_Ones_II();
        int[] nums = new int[] {1,0,1,1,0};
        Assert.assertEquals(4, q.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int zeroCount = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[j] == 0) {
                    zeroCount--;
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
