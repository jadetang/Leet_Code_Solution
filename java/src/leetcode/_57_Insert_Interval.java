package leetcode;

import ds.Interval;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author jade on 2017/5/4 下午3:06
 */
public class _57_Insert_Interval {


  public static void main(String[] args) {
    _57_Insert_Interval q = new _57_Insert_Interval();
    List<Interval> intervals = new LinkedList<>();
    intervals.add(new Interval(3, 4));
    q.insert(intervals, new Interval(5, 7));
  }

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    TreeSet<Interval> treeSet = new TreeSet<>((o1, o2) -> {
      if (o1.start == o2.start) {
        return o1.end - o2.end;
      } else {
        return o1.start - o2.start;
      }
    });
    treeSet.addAll(intervals);
    treeSet.add(newInterval);
    Interval[] intervalArray = treeSet.toArray(new Interval[]{});
    List<Interval> result = new LinkedList<>();
    for (int i = 0; i < intervalArray.length; i++) {
      Interval current = intervalArray[i];
      while (i < intervalArray.length - 1 && canMerge(current, intervalArray[i + 1])) {
        current = merge(current, intervalArray[i + 1]);
        i++;
      }
      result.add(current);

    }
    return result;
  }

  private boolean canMerge(Interval l1, Interval l2) {
    return !(l1.end < l2.start || l1.start > l2.end);
  }

  private Interval merge(Interval l1, Interval l2) {
    return new Interval(Math.min(l1.start, l2.start), Math.max(l1.end, l2.end));
  }


}
