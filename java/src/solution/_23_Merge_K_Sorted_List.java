package solution;

import java.util.PriorityQueue;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午1:18
 */
public class _23_Merge_K_Sorted_List {

    //这个算法是 logN
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> p = new PriorityQueue<>(100, (l1, l2) -> l1.val - l2.val);
        //O(k)
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                p.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // q 里面的元素不会大于k，取一个元素的时间是 logK
        while (!p.isEmpty()) {
            tail.next = p.poll();
            tail = tail.next;
            if (tail.next != null) {
                p.add(tail.next);
            }

        }
        return dummy.next;
    }

    //  nlogk where k is the number of lists and n is total number of nodes.
    public static ListNode mergeKLists2(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) { return lists[s]; }
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else { return null; }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
