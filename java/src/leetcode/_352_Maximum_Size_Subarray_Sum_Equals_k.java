package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _352_Maximum_Size_Subarray_Sum_Equals_k {

    public int maxSubArrayLen(int[] nums, int k) {
        int[] presum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            if (presum[i] == k) {
                ans = Math.max(ans, i);
            }else if(map.containsKey(presum[i] - k)) {
                ans = Math.max(ans, i - map.get(presum[i] - k));
            }
            if (!map.containsKey(presum[i])) {
                map.put(presum[i], i);
            }
        }
        return ans;
    }

}
