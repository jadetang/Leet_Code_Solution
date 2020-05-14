package leetcode;

import ds.TreeNode;


public class _1373_Maximum_Sum_BST_in_Binary_Tree {

  int ans = 0;

  public int maxSumBST(TreeNode root) {
    bst(root);
    return ans;
  }

  private int[] bst(TreeNode node) {
    if (node == null) {
      return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 1, 0};
    } else {
      int[] leftResult = bst(node.left);
      int[] rightResult = bst(node.right);
      if (leftResult[2] == 1 && rightResult[2] == 1 && node.val > leftResult[1]
          && node.val < rightResult[1]) {
        ans = Math.max(ans, node.val + leftResult[3] + rightResult[3]);
        return new int[]{Math.min(node.val, leftResult[0]), Math.max(node.val, rightResult[1]), 1,
            node.val + leftResult[3] + rightResult[3]};
      } else {
        return new int[]{Math.min(node.val, leftResult[0]), Math.max(node.val, rightResult[1]), 0,
            node.val + leftResult[3] + rightResult[3]};
      }
    }
  }
}
