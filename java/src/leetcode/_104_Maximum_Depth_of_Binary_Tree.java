package leetcode;

import ds.TreeNode;

/**
 * @author jade on 2017/7/2 上午11:12
 */
public class _104_Maximum_Depth_of_Binary_Tree {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
  }
}
