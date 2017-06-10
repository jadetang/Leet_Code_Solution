package solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2016/10/15 下午9:54
 */
public class _416_Partitio_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        List<Integer> left = new ArrayList<>();
        left.add(0, nums[0]);
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == dp[i - 1]) {
                int index = Collections.binarySearch(right, nums[i]);
                if (index >= 0) {
                    right.add(i, nums[i]);
                } else {
                    int insertIndex = -index - 1;
                    right.add(insertIndex, nums[i]);
                    dp[i] = 0;
                }
            } else if (nums[i] > dp[i - 1]) {
                int diff = nums[i] - dp[i-1];
                
            } else {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
        int index = Collections.binarySearch(left, 0);
        System.out.println(index);
    }
}
