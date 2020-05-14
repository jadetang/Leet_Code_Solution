package leetcode;

import ds.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class _549_Binary_Tree_Longest_Consecutive_Sequence_II {

    @Test
    public void test() {
        _549_Binary_Tree_Longest_Consecutive_Sequence_II q = new _549_Binary_Tree_Longest_Consecutive_Sequence_II();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Assert.assertEquals(3, q.longestConsecutive(root));
    }

    @Test
    public void test2() {
        _549_Binary_Tree_Longest_Consecutive_Sequence_II q = new _549_Binary_Tree_Longest_Consecutive_Sequence_II();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        Assert.assertEquals(2, q.longestConsecutive(root));
    }

    int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        driver(root);
        return maxLength;
    }

    private int[] driver(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        if (node.left == null && node.right == null) {
            maxLength = Math.max(maxLength, 1);
            return new int[] {1, 1};
        }
        int increaseMax = 1;
        int decreaseMax = 1;
        int[] leftMax = new int[2];
        int[] rightMax = new int[2];
        if (node.left != null) {
            leftMax = driver(node.left);
            if (node.val == node.left.val + 1) {
                increaseMax = Math.max(increaseMax, 1 + leftMax[0]);
            }else if (node.val == node.left.val - 1){
                decreaseMax = Math.max(decreaseMax, 1 + leftMax[1]);
            }
        }
        if (node.right != null) {
            rightMax = driver(node.right);
            if (node.val == node.right.val + 1) {
                increaseMax = Math.max(increaseMax, 1 + rightMax[0]);
            }else if (node.val == node.right.val - 1){
                decreaseMax = Math.max(decreaseMax, 1 + rightMax[1]);
            }
        }
        if (node.left != null && node.right != null) {
            if (node.val == node.left.val + 1 && node.val == node.right.val -1) {
                int tempLength = 1 + leftMax[0] + rightMax[1];
                maxLength = Math.max(tempLength, maxLength);
            }
            if (node.val == node.left.val - 1 && node.val == node.right.val + 1) {
                int tempLength = 1 + leftMax[1] + rightMax[0];
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        maxLength = Math.max(increaseMax, maxLength);
        maxLength = Math.max(decreaseMax, maxLength);
        return new int[] {increaseMax, decreaseMax};
    }

}
