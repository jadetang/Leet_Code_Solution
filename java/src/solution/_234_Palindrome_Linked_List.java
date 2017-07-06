package solution;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/5 下午9:35
 */
public class _234_Palindrome_Linked_List {


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reserve(slow);
        while ( slow != null ){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;

    }

    private ListNode reserve(ListNode slow) {
        ListNode head = slow;
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
