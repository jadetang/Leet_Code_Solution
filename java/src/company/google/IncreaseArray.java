package company.google;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.Assert;

/**
 * Given an array of +ve numbers and another array of same size with zeros.
 * Here are the operations you're allowed to perform on the second array.
 *
 * You're allowerd to increment only a subarray of values. [Subarray has to be a contiguous block]
 * You're allowerd to increment the values of the subarray by a value of 1.
 * How many increment operations does it require to transform second array of zeros to the first array?
 *
 * Input:
 * [3, 4, 2, 5, 7]
 */
public class IncreaseArray {

  int ans = 0;

  SegmentTree tree;

  public int increaseTimes(int[] array) {
    this.tree = new SegmentTree(array);
    solve(array, 0, array.length - 1, 0);
    return ans;
  }

  private void solve(int[] array, int start, int end, int currentLeast) {
    if (start == end) {
      ans += array[start] - currentLeast;
      return;
    }
    if (start > end) {
      return;
    }
    List<Integer> index = tree.query(start, end);
    ans += array[index.get(0)] - currentLeast;
    for (int i = 0; i < index.size(); i++) {
      if (i == 0) {
        solve(array, start, index.get(i) - 1, array[index.get(0)]);
      }
      if (i == index.size() - 1) {
        solve(array, index.get(i) + 1, end,  array[index.get(0)]);
      }
      if ( i > 0 && i < index.size() - 1) {
        solve(array, index.get(i) + 1, index.get(i + 1) - 1, array[index.get(0)]);
      }
    }
  }

  @Test
  public void test() {
    IncreaseArray increaseArray = new IncreaseArray();
    Assert.assertEqual(9, increaseArray.increaseTimes(new int[]{3, 4, 2, 5, 7}));
  }

  public static class SegmentTree {

    SegmentTreeNode root;

    int[] array;

    public SegmentTree(int[] array) {
      this.root = build(0, array.length - 1, array);
      this.array = array;
    }

    private SegmentTreeNode build(int start, int end, int[] array) {
      if (start == end) {
        return new SegmentTreeNode(start, end, null, null, List.of(start));
      } else {
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = build(start, mid, array);
        SegmentTreeNode right = build(mid + 1, end, array);
        if (array[left.index.get(0)] < array[right.index.get(0)]) {
          return new SegmentTreeNode(start, end, left, right, left.index);
        } else if (array[left.index.get(0)] > array[right.index.get(0)]) {
          return new SegmentTreeNode(start, end, left, right, right.index);
        } else {
          List<Integer> indexList = new ArrayList<>();
          indexList.addAll(left.index);
          indexList.addAll(right.index);
          return new SegmentTreeNode(start, end, left, right, indexList);
        }
      }
    }

    public List<Integer> query(int start, int end) {
      return query(root, start, end);
    }

    private List<Integer> query(SegmentTreeNode node, int start, int end) {
      if (node.start == start && node.end == end) {
        return node.index;
      }
      int mid = node.start + (node.end - node.start) / 2;
      if (end <= mid) {
        return query(node.left, start, end);
      } else if (start >= mid + 1) {
        return query(node.right, start, end);
      } else {
        List<Integer> leftPart = query(node.left, start, mid);
        List<Integer> rightPart = query(node.right, mid + 1, end);
        if (array[leftPart.get(0)] < array[rightPart.get(0)]) {
          return leftPart;
        } else if (array[leftPart.get(0)] > array[rightPart.get(0)]) {
          return rightPart;
        } else {
          List<Integer> indexlist = new ArrayList<>();
          indexlist.addAll(leftPart);
          indexlist.addAll(rightPart);
          return indexlist;
        }
      }
    }
  }

  public static class SegmentTreeNode {

    List<Integer> index;

    int start;

    int end;

    SegmentTreeNode left;

    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end,
        SegmentTreeNode left, SegmentTreeNode right, List<Integer> index) {
      this.index = index;
      this.start = start;
      this.end = end;
      this.left = left;
      this.right = right;
    }
  }

}
