package leetcode;

import ds.ListNode;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jade on 16/7/16 下午8:05
 */
public class _25_Reverse_Nodes_in_k_Group {

  @Test
  public void test( ) {
    ListNode list = ListNode.from(new int[] {1, 2, 3, 4, 5});
    _25_Reverse_Nodes_in_k_Group q = new _25_Reverse_Nodes_in_k_Group();
    ListNode reverse = q.reverseKGroup2(list, 2);
    Assert.assertEquals(List.of(2, 1, 4, 3, 5), ListNode.toList(reverse));
  }

  public ListNode reverseKGroup2(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) {
      return head;
    }
    ListNode temp = head;
    int length = 0;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
    int reverseTime = length / k;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 0; i < reverseTime; i++) {
      Stack<ListNode> stack = new Stack<>();
      for (int j = 0; j < k; j++) {
        stack.push(head);
        head = head.next;
      }
      while (!stack.isEmpty()) {
        pre.next = stack.pop();
        pre = pre.next;
      }
      pre.next = head;
    }
    return dummy.next;
  }

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

}
