package solution;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/3 下午1:42
 */
public class _206_Reverse_Linked_List {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    } else if (head.next == null) {
      return head;
    } else {

      return reserve(head, null);

    }
  }

  private ListNode reserve(ListNode cur, ListNode pre) {
    if (cur.next == null) {
      cur.next = pre;
      return cur;
    } else {
      ListNode c = cur.next;
      cur.next = pre;
      return reserve(c, cur);

    }
  }

  public ListNode reverseList2(ListNode head) {
    /* iterative solution */
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public ListNode reverseList3(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }


  public ListNode reverseList4(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }


}
