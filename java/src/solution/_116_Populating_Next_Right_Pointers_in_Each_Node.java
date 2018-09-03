package solution;

import ds.TreeLinkNode;

/**
 * 也可以分层次遍历树，然后得到一个个列表，然后连起来。
 *
 * @author jade on 2017/7/2 下午2:28
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode levelStart = root;
    while (levelStart != null) {
      TreeLinkNode cur = levelStart;
      while (cur != null) {
        if (cur.left != null) {
          cur.left.next = cur.right;
        }
        if (cur.right != null && cur.next != null) {
          cur.right.next = cur.next.left;
        }
        cur = cur.next;
      }
      levelStart = levelStart.left;
    }
  }
}
