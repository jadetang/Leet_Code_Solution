package leetcode;

import ds.TreeNode;

/**
 * @author jade on 2017/6/4 下午3:06
 */
public class _572_Subtree_of_Another_Tree {


  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s != null && t != null) {
      if (match(s, t)) {
        return true;
      } else {
        return isSubtree(s.left, t) || isSubtree(s.right, t);
      }
    } else {
      return false;
    }
  }

  private boolean match(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if ((s == null && t != null) || (s != null && t == null)) {
      return false;
    } else {
      return (t.val == s.val) && match(s.left, t.left) && match(s.right, t.right);
    }
  }


}
