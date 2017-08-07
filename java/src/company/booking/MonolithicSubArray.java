package company.booking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/7/8 下午5:38
 */
public class MonolithicSubArray {


    public static List<List<Integer>> monolithicSubArray(int[] nums){

        List<List<Integer>> list = new LinkedList<>();

        for (int i = 0  ; i < nums.length ; i++){
            List<Integer> temp = new LinkedList<>();
            temp.add(nums[i]);
            while ( i < nums.length - 1 && nums[i] < nums[i+1]){
                i++;
                temp.add(nums[i]);
            }
            list.add(temp);



        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(monolithicSubArray(new int[]{1,2,4,7,5,6,3,2}));
    }


}
