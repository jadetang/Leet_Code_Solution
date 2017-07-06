package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            List<Integer> temp = IntStream.of(nums).boxed().collect(Collectors.toList());;
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

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> acc = new LinkedList<>();
        help(acc, new ArrayList<>() ,nums);
        return acc;
    }

    private void help(List<List<Integer>> acc, ArrayList<Integer> temp, int[] nums){
        if ( temp.size() == nums.length){
            acc.add(new LinkedList<>(temp));
        }else {
            for ( int i = 0 ; i < nums.length ; i++){
                if (temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                help(acc,temp,nums);
                temp.remove(temp.size() - 1);
            }
        }
    }




    public static void main(String[] args) {
        _46_Permutations q = new _46_Permutations();
        System.out.println(q.permute(new int[]{1,2,3}));
        System.out.println(q.permute2(new int[]{1,2,3}));
    }


}
