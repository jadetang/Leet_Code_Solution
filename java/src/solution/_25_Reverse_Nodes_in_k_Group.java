package solution;

import ds.ListNode;

/**
 * @author jade on 16/7/16 下午8:05
 */
public class _25_Reverse_Nodes_in_k_Group {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode tail = dummy, prev = dummy, temp;
    int count;
    while (true) {
      count = k;
      while (count > 0 && tail != null) {
        count--;
        tail = tail.next;
      }
      if (tail == null) {
        break;//Has reached the end
      }

      head = prev.next;//for next cycle
      // prev-->temp-->...--->....--->tail-->....
      // Delete @temp and insert to the next position of @tail
      // prev-->...-->...-->tail-->head-->...
      // Assign @temp to the next node of @prev
      // prev-->temp-->...-->tail-->...-->...
      // Keep doing until @tail is the next node of @prev
      while (prev.next != tail) {
        temp = prev.next;//Assign
        prev.next = temp.next;//Delete

        temp.next = tail.next;
        tail.next = temp;//Insert

      }

      tail = head;
      prev = head;

    }
    return dummy.next;

  }

  public static void main(String[] args) {
    ListNode l = new ListNode(1);
    ListNode l2 = new ListNode(2);
    l.next = l2;
    _25_Reverse_Nodes_in_k_Group s = new _25_Reverse_Nodes_in_k_Group();
    s.reverseKGroup(l, 2);
  }

}
