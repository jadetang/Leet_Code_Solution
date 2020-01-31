/*
package leetcode;


*/
/**
 * @author jade on 2016/11/10 上午8:51
 *//*

public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode node, int target){
        if(node == null ){
            return false;
        }else if( node.left == null || node.right == null ){
            if( node.val == target ){
                return true;
            }
        }else{
            return helper(node.left,target-node.val) || helper(node.right,target-node.val);
        }
    }
}
*/
