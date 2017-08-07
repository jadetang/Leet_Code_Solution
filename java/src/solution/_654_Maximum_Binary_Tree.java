package solution;

import ds.TreeNode;

/**
 * @author sanguan.tangsicheng on 2017/8/6 下午10:41
 */
public class _654_Maximum_Binary_Tree {

    //平均 nlogn， 最坏 n^2
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return null;
        }
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int start, int end){
        if( start > end ){
            return null;
        }else if( start == end ){
            return new TreeNode(nums[start]);
        }else{
            int index = findLargest(nums, start, end);
            TreeNode node = new TreeNode(nums[index]);
            node.left = construct(nums, start, index-1);
            node.right = construct(nums, index+1, end);
            return node;
        }
    }

    private int findLargest(int[] nums, int start, int end){
        int index = start;
        for( int i = start; i <= end; i++ ){
            if( nums[i] > nums[index] ){
                index = i;
            }
        }
        return index;
    }
}
