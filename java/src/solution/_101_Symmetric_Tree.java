package solution;

import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 还有一种方式，前序遍历和后序遍历一遍，如果两个相同，表示是一样的。
 *
 * @author jade on 2016/11/12 下午8:31
 */
public class _101_Symmetric_Tree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return isSame(root.left, root.right);
    }
  }

  private boolean isSame(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.val != right.val) {
      return false;
    } else {
      return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
  }

  //遍历的方式
  public boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) {
        continue;
      }
      if (t1 == null || t2 == null) {
        return false;
      }
      if (t1.val != t2.val) {
        return false;
      }
      q.add(t1.left);  //注意添加的顺序
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }
}
