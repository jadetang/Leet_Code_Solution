package solution;

import java.util.LinkedList;
import java.util.List;

/** 排列，考虑顺序
 * @author sanguan.tangsicheng on 2016/11/19 下午12:50
 */
public class _46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> acc = new LinkedList<>();
        help(acc, nums ,0,nums.length - 1);
        return acc;
    }

    private void help(List<List<Integer>> acc,int[] nums, int l,int r){
        if (l == r) {
            List<Integer> temp = new LinkedList();
            for (Integer i : nums ) {
                temp.add(i);
            }
            acc.add(temp);
        }else {
            for (int i = l; i <= r; i++) {
                swap(nums,l,i);
                help(acc,nums,l+1,r);
                swap(nums,l,i);
            }
        }
    }

    private void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    public static void main(String[] args) {
        _46_Permutations q = new _46_Permutations();
        System.out.println(q.permute(new int[]{'a','b','c'}));
    }


}
