package leetcode;

import ds.TreeNode;

public class _270_Closest_Binary_Search_Tree_Value {

  public int closestValue(TreeNode root, double target) {
    return find(root, target).val;
  }

  private TreeNode find(TreeNode node, double target) {
    if (node == null) {
      return null;
    }
    if (node.val == target) {
      return node;
    }else if (node.val > target){
      TreeNode leftCloseNode = find(node.left, target);
      if (leftCloseNode != null) {
        return Math.abs((double)leftCloseNode.val - target) > Math.abs((double)node.val - target) ? leftCloseNode : node;
      }
      return node;
    }else {
      TreeNode rightCloseNode = find(node.right, target);
      if (rightCloseNode != null) {
        return Math.abs((double)rightCloseNode.val - target) > Math.abs((double)node.val - target) ? rightCloseNode : node;
      }
      return node;
    }
 }


}
