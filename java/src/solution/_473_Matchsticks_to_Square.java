package solution;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author sanguan.tangsicheng on 2017/7/30 下午2:45
 */
public class _473_Matchsticks_to_Square {


    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = IntStream.of(nums).sum();
        if (sum % 4 != 0) {
            return false;
        } else {
            int length = sum / 4;
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            int side = 4;
            while (side > 0) {
                if (canFill(length, nums, used)) {
                    side--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean canFill(int length, int[] nums, boolean[] used) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!used[i] && nums[i] <= length) {
                used[i] = true;
                length -= nums[i];
                if (length == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        _473_Matchsticks_to_Square q = new _473_Matchsticks_to_Square();
        int[] matches = new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        q.makesquare(matches);
    }


}
