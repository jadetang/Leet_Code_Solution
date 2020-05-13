package company.snowflake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class MergeList {


  public static List<Integer> mergeTwo(List<Integer> l1, List<Integer> l2) {
    var i1 = l1.iterator();
    var i2 = l2.iterator();
    var ret = new ArrayList<Integer>();
    Integer v1 = null, v2 = null;
    if (i1.hasNext()) {
      v1 = i1.next();
    }
    if (i2.hasNext()) {
      v2 = i2.next();
    }
    while (v1 != null && v2 != null) {
      if (v1 < v2) {
        ret.add(v1);
        v1 = i1.hasNext() ? i1.next() : null;
      } else {
        ret.add(v2);
        v2 = i2.hasNext() ? i2.next() : null;
      }
    }
    while (v1 != null || v2 != null) {
      if (v1 != null) {
        ret.add(v1);
        v1 = i1.hasNext() ? i1.next() : null;
      } else {
        ret.add(v2);
        v2 = i2.hasNext() ? i2.next() : null;
      }
    }
    return ret;
  }

  @Test
  public void test() {
    MergeList merge = new MergeList();
    System.out.println(merge.merge(List.of(1, 2, 3, 6), List.of(2, 3, 5)));
    System.out.println(merge.mergeTwo(List.of(1, 2, 3, 6), List.of(2, 3, 5, 10)));
    System.out.println(merge.mergeTwo(List.of(), List.of(2, 3, 5)));
    System.out.println(merge.mergeTwo(List.of(2, 2, 2, 2), List.of(2, 3, 5)));
  }

  public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
    List<Integer> ans = new ArrayList<>();
    Integer left = null;
    Integer right = null;
    Iterator<Integer> it1 = list1.iterator();
    Iterator<Integer> it2 = list2.iterator();
    while (it1.hasNext() || it2.hasNext()) {
      if (left == null) {
        left = it1.hasNext() ? it1.next() : null;
      }
      if (right == null) {
        right = it2.hasNext() ? it2.next() : null;
      }
      if (left == null) {
        ans.add(right);
        right = null;
      } else if (right == null) {
        ans.add(left);
        left = null;
      } else {
        if (left <= right) {
          ans.add(left);
          left = null;
        } else {
          ans.add(right);
          right = null;
        }
      }
    }
    if (left != null) {
      ans.add(left);
    }
    if (right != null) {
      ans.add(right);
    }
    return ans;
  }
}
