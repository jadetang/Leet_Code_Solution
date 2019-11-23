package leetcode;

import ds.TreeNode;

/**
 * @author jade on 2016/11/13 上午10:38
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

  public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      return lowestCommonAncestor2(root, q, p);
    }

    if (root == null) {
      return null;
    }
    if (root.val == p.val || root.val == q.val) {
      return root;
    }
    if (root.val > p.val && root.val < q.val) {
      return root;
    } else if (root.val > q.val) {
      return lowestCommonAncestor2(root.left, p, q);
    } else {
      return lowestCommonAncestor2(root.right, p, q);
    }
  }

  public static void main(String[] args) {
    TreeNode t = new TreeNode(2);
    t.left = new TreeNode(1);
    t.right = new TreeNode(3);
    lowestCommonAncestor2(t, new TreeNode(3), new TreeNode(1));
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.left == p && root.right == q) {
      return root;
    }
    TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
    TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
    if (leftAncestor != null && rightAncestor != null) {
      return root;
    } else {
      return leftAncestor == null ? rightAncestor : leftAncestor;
    }
  }


}
