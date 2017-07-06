package solution;

import java.util.Arrays;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午12:19
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

    /**
     * 也可以传数组小标，这样就不用拷贝数组了
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }else if(nums.length == 1){
            return new TreeNode(nums[0]);
        }else{
            int mid = nums.length / 2;
            TreeNode t = new TreeNode(nums[mid]);
            int[] left = Arrays.copyOfRange(nums,0,mid);
            int[] right = Arrays.copyOfRange(nums,mid+1,nums.length);
            t.left = sortedArrayToBST(left);
            t.right = sortedArrayToBST(right);
            return t;
        }
    }
}
