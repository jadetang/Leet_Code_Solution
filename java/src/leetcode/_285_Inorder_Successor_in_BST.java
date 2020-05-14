package leetcode;

import ds.TreeNode;

public class _285_Inorder_Successor_in_BST {

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
      return null;
    }else if (root.val < p.val) {
      return inorderSuccessor(root.right, p);
    }else if (root.val > p.val) {
      TreeNode t = inorderSuccessor(root.left, p);
      return t != null ? t : root;
    }else {
      return findSmallestOne(root.right);
    }
  }

  private TreeNode findSmallestOne(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode smallestOne = node;
    while (smallestOne.left != null) {
      smallestOne = smallestOne.left;
    }
    return smallestOne;
  }
}
