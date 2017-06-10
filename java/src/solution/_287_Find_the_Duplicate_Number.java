package solution;

/**
 * @author sanguan.tangsicheng on 2016/12/15 上午9:15
 */
public class _287_Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        for(int i= 0 ; i < nums.length ; i++){
            int index = Math.abs(nums[i]-1);
            nums[ index ] = - nums[index];
        }
        for(int i= 0 ; i < nums.length ; i++ ){
            if(nums[i] > 0 ){
                return i+1;
            }
        }
        return -1;
    }
}
