package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jade on 16/7/16 下午8:06
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static ListNode from(int[] array) {
    ListNode dummy = new ListNode(-1);
    ListNode node = dummy;
    for (int i = 0; i < array.length; i++) {
      node.next = new ListNode(array[i]);
      node = node.next;
    }
    return dummy.next;
  }

  public static List<Integer> toList(ListNode node) {
    List<Integer> list = new ArrayList<>();
    while (node != null) {
      list.add(node.val);
      node = node.next;
    }
    return list;
  }
}
