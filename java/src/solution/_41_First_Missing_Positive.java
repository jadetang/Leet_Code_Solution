package solution;

import level.Medium;
import tag.Array;
import util.Util;

/**
 * @author sanguan.tangsicheng on 2017/5/3 下午10:53
 */
public class _41_First_Missing_Positive implements Array, Medium {

    public int firstMissingPositive(int[] nums) {
        Util.print(nums);
        for( int i = 0 ; i < nums.length ; i ++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i]-1);
                Util.print(nums);
            }
        }
        Util.print(nums);
        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return nums.length + 1;
    }


    private  void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4};
        _41_First_Missing_Positive q = new _41_First_Missing_Positive();
        System.out.println(q.firstMissingPositive(nums));
    }


}
