package solution;

import ds.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 *
 * @author sanguan.tangsicheng on 2017/5/21 下午4:24
 */
public class _142_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }

        }
        return null;
    }

}
