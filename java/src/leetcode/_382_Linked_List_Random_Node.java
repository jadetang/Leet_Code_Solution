package leetcode;

import ds.ListNode;
import java.util.Random;

/**
 * @author jade on 2016/11/13 下午3:53
 */
public class _382_Linked_List_Random_Node {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    n1.next = n2;
    n2.next = n3;
    //Solution q = new Solution(n1);
    for (int i = 0; i < 100; i++) {
      Solution q = new Solution(n1);
      System.out.println(q.getRandom());
    }
  }

  public static class Solution {

    ListNode head;

    /**
     * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
     * contains at least one node.
     */
    public Solution(ListNode head) {
      this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
      int value = this.head.val;
      int count = 1;
      Random random = new Random();
      ListNode head = this.head;
      while (head.next != null) {
        head = head.next;
        count++;
        if (random.nextDouble() <= 1.0 / count) {
          value = head.val;
        }
      }
      return value;

    }
  }
}
