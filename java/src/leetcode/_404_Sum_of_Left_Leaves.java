package leetcode;

import ds.TreeNode;

public class _404_Sum_of_Left_Leaves {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        collect(root);
        return ans;
    }

    private void collect(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            ans += node.left.val;
        }
        collect(node.left);
        collect(node.right);
    }

}
