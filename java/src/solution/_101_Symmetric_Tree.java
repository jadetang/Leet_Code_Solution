package solution;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sanguan.tangsicheng on 2016/11/12 下午8:31
 */
public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null){
            return true;
        }else {
            return isSame(root.left,root.right);
        }
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if(left == null && right == null ){
            return true;
        }else if (left == null || right == null ){
            return false;
        }else if (left.val != right.val){
            return false;
        }else {
            return isSame(left.left,right.right) && isSame(left.right,right.left);
        }
    }


}
