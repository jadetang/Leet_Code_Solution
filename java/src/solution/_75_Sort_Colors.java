package solution;

import level.Medium;
import tag.Array;

/**
 * @author sanguan.tangsicheng on 2017/5/4 下午10:07
 */
public class _75_Sort_Colors implements Array, Medium {


    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int oneIndex = 0;
        while ( oneIndex <= twoIndex){
           if ( nums[oneIndex] == 1 ){
               oneIndex++;
           }else if ( nums[oneIndex] < 1 ){
               swap(nums,zeroIndex++,oneIndex++);
           }else {
                swap(nums,oneIndex,twoIndex--);
           }
        }
    }


    private void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
