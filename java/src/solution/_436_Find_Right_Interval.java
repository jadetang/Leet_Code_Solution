package solution;

import ds.Interval;

import java.util.Arrays;

/**
 * @author sanguan.tangsicheng on 2016/11/14 上午7:28
 */
public class _436_Find_Right_Interval {

  public int[] findRightInterval(Interval[] intervals) {
    Interval[] sortedIntervals = Arrays.copyOf(intervals, intervals.length);
    Arrays.sort(sortedIntervals, (o1, o2) -> o1.start - o2.start);
    int[] result = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      Interval current = intervals[i];
      int insertIndex = Arrays
          .binarySearch(sortedIntervals, current, (o1, o2) -> o1.start - o2.end);
      if (insertIndex < 0) {
        insertIndex = -insertIndex - 1;
      }
      if (insertIndex == intervals.length) {
        result[i] = -1;
      } else {
        Interval match = sortedIntervals[insertIndex];
        for (int j = 0; j < intervals.length; j++) {
          if (i != j && match.start == intervals[j].start && match.end == intervals[j].end) {
            // System.out.println(",old index:"+j);
            result[i] = j;
          }
        }
      }

    }
    return result;
  }


  public static void main(String[] args) {
    _436_Find_Right_Interval q = new _436_Find_Right_Interval();
    Interval[] i = new Interval[]{new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)};
    int[] reuslt = q.findRightInterval(i);
    for (int num :
        reuslt) {
      System.out.println(num);
    }
  }


}
