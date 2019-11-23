package leetcode;

import ds.TreeNode;

/**
 * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for
 * given sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side
 * of ‘A’ are in left subtree and elements on right are in right subtree. So we know below structure
 * now.
 *
 * A /   \ /       \ D B E     F C We recursively follow above steps and get the following tree.
 *
 * A /   \ /       \ B         C / \        / /     \    / D       E  F
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 *
 * @author jade on 2017/6/3 上午9:06
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
  }

  public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        inIndex = i;
      }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
  }
}
