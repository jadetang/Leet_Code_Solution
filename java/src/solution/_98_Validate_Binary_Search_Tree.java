package solution;

import ds.TreeNode;

/** 还有一种解法不是，中序遍历树，得到一个严格递增的队列
 * @author sanguan.tangsicheng on 2017/7/2 上午10:47
 */
public class _98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
            ;
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        } else if (root.val <= minValue || root.val >= maxValue) {
            return false;
        } else {
            return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
        }

    }

}