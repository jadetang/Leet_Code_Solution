package leetcode;

import ds.ListNode;

/**
 * @author jade on 2017/7/2 下午6:17
 */
public class _141_Linked_List_Cycle {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (slow != null && fast != null) {
      if (slow == fast) {
        return true;
      }
      if (fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
