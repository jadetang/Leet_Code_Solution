package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class _560_Subarray_Sum_Equals_K {

    @Test
    public void test() {
        int[] array = new int[] {1,1,1};
        _560_Subarray_Sum_Equals_K q = new _560_Subarray_Sum_Equals_K();
        Assert.assertEquals(2, q.subarraySum(array, 2));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        int sum = 0;
        for (int i : nums) {
            sum += i;
            ans += map.getOrDefault(sum -k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
