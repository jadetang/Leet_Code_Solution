package leetcode;

import ds.TreeNode;

/**
 * @author jade on 2016/11/16 下午9:22
 */
public class _230_Kth_Smallest_Element_in_a_BST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(3);
    root.left = left;
    root.right = right;
    _230_Kth_Smallest_Element_in_a_BST q = new _230_Kth_Smallest_Element_in_a_BST();
    System.out.println(q.kthSmallest(root, 2));
  }

  public int kthSmallest(TreeNode root, int k) {
    return rank(root, k - 1);
  }

  int rank(TreeNode root, int k) {
    int t = size(root.left);
    if (t > k) {
      return rank(root.left, k);
    } else if (t < k) {
      return rank(root.right, k - t - 1);
    } else {
      return root.val;
    }
  }

  private int size(TreeNode node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + size(node.left) + size(node.right);
    }
  }
}
