package solution;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午1:44
 */
public class _24_Swap_Node_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dumpNode = new ListNode(0);
        dumpNode.next = head;
        ListNode p = dumpNode;
        while (p != null && p.next != null && p.next.next != null) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = p.next.next;
            p.next.next = temp;
            p = p.next.next;
        }
        return dumpNode.next;
    }


    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}
