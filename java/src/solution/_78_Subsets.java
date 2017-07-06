package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/7/2 上午8:04
 */
public class _78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> acc = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        backtrack(acc,list,nums,0);
        return acc;
    }

    private void backtrack(List<List<Integer>> acc,List<Integer> list,int[] nums,int start){
        acc.add(new LinkedList<>(list));
        for(int i = start ; i < nums.length; i++ ){
            list.add(nums[i]);
            backtrack(acc,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
