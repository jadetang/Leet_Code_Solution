package leetcode;

import ds.Interval;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2017/5/4 上午11:42
 */
public class _56_Merge_Intervals {


  public static void main(String[] args) {
    List<Interval> l = new LinkedList<>();
  }

  public List<Interval> merge(List<Interval> intervals) {

    Collections.sort(intervals, (o1, o2) -> {
      if (o1.start == o2.start) {
        return o1.end - o2.end;
      } else {
        return o1.start - o2.start;
      }
    });
    intervals.forEach(l -> System.out.println("[" + l.start + "," + l.end + "]"));
    Interval[] intervalArray = intervals.toArray(new Interval[]{});
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
