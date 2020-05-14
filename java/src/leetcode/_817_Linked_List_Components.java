package leetcode;

import ds.ListNode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import leetcode._261_Graph_Valid_Tree.DSU;
import org.junit.Test;
import util.Assert;

public class _817_Linked_List_Components {

  int n = 10000;

  @Test
  public void test() {
    _817_Linked_List_Components q = new _817_Linked_List_Components();
    ListNode node = ListNode.from(new int[]{0, 1, 2, 3});
    Assert.assertEqual(2, q.numComponents(node, new int[]{0, 1, 3}));
  }

  public int numComponents(ListNode head, int[] g) {
    int[] array = new int[n];
    int[] reverseIndex = new int[n];
    Arrays.fill(array, -1);
    Arrays.fill(reverseIndex, -1);
    int index = 0;
    while (head != null) {
      reverseIndex[head.val] = index;
      array[index] = head.val;
      index++;
      head = head.next;
    }
    DSU dsu = new DSU(n);
    Set<Integer> set = IntStream.of(g).boxed().collect(Collectors.toSet());
    ;
    for (int i : set) {
      int pos = reverseIndex[i];
      if (pos > 0) {
        if (array[pos - 1] != -1 && set.contains(array[pos - 1])) {
          dsu.connect(i, array[pos - 1]);
        }
      }
      if (pos < array.length - 1) {
        if (array[pos + 1] != -1 && set.contains(array[pos + 1])) {
          dsu.connect(i, array[pos + 1]);
        }
      }
    }
    Set<Integer> roots = new HashSet<>();
    for (int i : set) {
      roots.add(dsu.find(i));
    }
    return roots.size();
  }
}
