package solution;

import ds.ListNode;
import level.Medium;

public class _2_Add_Two_Numbers implements Medium {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dumy = new ListNode(-1);
    ListNode cur = dumy;
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;
    while (p != null || q != null) {
      int pV = p != null ? p.val : 0;
      int qV = q != null ? q.val : 0;
      int sum = pV + qV + carry;
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      p = p != null ? p.next : p;
      q = q != null ? q.next : q;
    }
    if (carry > 0) {
      cur.next = new ListNode(carry);
    }
    return dumy.next;
  }

}
