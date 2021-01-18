package leetcode;

import ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class _333_Largest_BST_Subtree {

    @Test
    public void test() {
        var q = new _333_Largest_BST_Subtree();
        var root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(2, q.largestBSTSubtree(root));
    }

    int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return ans;
    }

    // [min, max, is bst, node number]
    private int[] traverse(TreeNode node) {
        if (node.left == null && node.right == null) {
            ans = Math.max(ans, 1);
            return new int[]{node.val, node.val, 1, 1};
        } else {
            int min = node.val;
            int max = node.val;
            int bst = 1;
            int number = 1;
            if (node.left != null) {
                int[] leftInfo = traverse(node.left);
                if(leftInfo[2] == 0 || node.val <= leftInfo[1]) {
                    bst = 0;
                }else {
                    min = leftInfo[0];
                    number += leftInfo[3];
                }
            }
            if (node.right != null) {
                int[] rightInfo = traverse(node.right);
                if(rightInfo[2] == 0 || node.val >= rightInfo[0]) {
                    bst = 0;
                }else {
                    max = rightInfo[1];
                    number += rightInfo[3];
                }
            }
            if (bst == 1) {
                ans = Math.max(ans, number);
            }
            return new int[] {min, max, bst, number};
        }
    }
}
