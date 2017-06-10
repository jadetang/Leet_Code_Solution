package solution;

import java.util.Random;

/**
 * @author sanguan.tangsicheng on 2016/11/13 下午4:21
 */
public class _398_Random_Pick_Index {


    public static class Solution {

        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int value = target - 1;
            int count = 0;
            int index = -1;
            Random r = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (value == target) {
                        count++;
                        if (r.nextDouble() <= 1.0 / count) {
                            index =  i;
                        }
                    } else {
                        value = target;
                        count = 1;
                        index = i;
                    }
                }
            }
            return index;

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1, 2, 3, 3, 3});
        for (int i = 0; i < 1000; i++) {
            System.out.println(s.pick(3));
        }
    }
}
