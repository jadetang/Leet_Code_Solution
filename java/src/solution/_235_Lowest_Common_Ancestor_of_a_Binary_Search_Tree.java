package solution;

import ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanguan.tangsicheng on 2016/11/13 上午10:38
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null) return null;
        if( root.left == p && root.right == q ) return root;
        TreeNode leftAncestor = lowestCommonAncestor(root.left,p,q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right,p,q);
        if( leftAncestor != null && rightAncestor != null ){
            return root;
        }else{
            return leftAncestor == null ? rightAncestor : leftAncestor;
        }
    }
}
