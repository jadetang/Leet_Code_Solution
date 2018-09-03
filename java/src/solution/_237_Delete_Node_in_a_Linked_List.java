package solution;

import ds.ListNode;

/**
 * @author jade on 2017/7/5 下午10:39
 */
public class _237_Delete_Node_in_a_Linked_List {

  /**
   * 把后面一个节点的值赋给当前值，然后将下一个节点删除
   */
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
