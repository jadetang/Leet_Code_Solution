package leetcode;

import ds.TreeNode;

public class _669_Trim_A_Binary_Search_Tree {

  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
      return null;
    }
    if (root.val < L) {
      return trimBST(root.right, L, R);
    }
    if (root.val > R) {
      return trimBST(root.left, L, R);
    }
    if (root.val >= L && root.val <= R) {
      root.left = trimBST(root.left, L, root.val - 1);
      root.right = trimBST(root.right, root.val + 1, R);
      return root;
    }
    throw new RuntimeException("should not reach here");
  }

}
