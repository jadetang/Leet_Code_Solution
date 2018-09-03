package solution;

import ds.ListNode;

/**
 * 合并排序列表
 *
 * @author jade on 2017/7/1 下午12:21
 */
public class _21_Merge_Two_Sorted_Lists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else {
      ListNode dump = new ListNode(-1);
      ListNode current = dump;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          current.next = l1;
          l1 = l1.next;
        } else {
          current.next = l2;
          l2 = l2.next;
        }
        current = current.next;
      }
      if (l1 == null) {
        current.next = l2;
      } else {
        current.next = l1;
      }
      return dump.next;
    }
  }

}
