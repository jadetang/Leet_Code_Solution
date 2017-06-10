package solution;

import tag.Array;
import tag.Greedy;

/**
 *   Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.

 * @author sanguan.tangsicheng on 2016/11/26 下午10:00
 */
public class _55_Jump_Game implements Array, Greedy {

    public boolean canJump(int[] nums){
        if (nums.length == 1){
            return true;
        }
        int maxJump =0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxJump--;
            if (maxJump < nums[i]){
                maxJump = nums[i];
            }
            if (maxJump == 0 ){
                return false;
            }
            if (maxJump+i >= n - 1){
                return true;
            }
        }
        return false;
    }




    //this method will cause stack overflow
    boolean[] dp;

    public boolean canJump2(int[] nums) {
        dp = new boolean[nums.length];
        return canJump(nums,0);
    }


    private boolean canJump(int[ ] nums,int index){
        if (index >= nums.length) {
            return false;
        }

        if (dp[index] == true) {
            return false;
        }

        int step = nums[index];
        dp[index] = true;
        if (step+index>= nums.length - 1) {
            dp[index] = true;
            return true;
        }else {
            for ( int i = index+step; i > index; i--){
                if (canJump(nums,i)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        _55_Jump_Game q = new _55_Jump_Game();
        long start = System.currentTimeMillis();
        int[] game = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        //int[] game = new int[]{2,3,1,1,4};
        //int[] game = new int[]{3,2,1,0,4};
        System.out.println(q.canJump(game));
        System.out.println("cost:"+ -(start-System.currentTimeMillis()));
        System.out.println(q.canJump2(game));
        System.out.println("cost:"+ -(start-System.currentTimeMillis()));
    }
}
