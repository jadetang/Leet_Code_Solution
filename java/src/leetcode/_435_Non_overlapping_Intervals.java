package leetcode;

import ds.Interval;
import java.util.Arrays;

/**
 * @author jade on 2016/11/17 下午6:35
 */
public class _435_Non_overlapping_Intervals {

  public static void main(String[] args) {
    _435_Non_overlapping_Intervals q = new _435_Non_overlapping_Intervals();
    Interval[] intervals = new Interval[]{
        new Interval(1, 100), new Interval(11, 22), new Interval(1, 11), new Interval(2, 12)
    };
    System.out.println(q.eraseOverlapIntervals(intervals));
  }

  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0 || intervals.length == 1) {
      return 0;
    } else {
      int result = 0;
      int[] mark = new int[intervals.length];
      Arrays.fill(mark, 0);
      Arrays.sort(intervals, (o1, o2) -> {
        if (o1.start == o2.start) {
          return o2.end - o1.end;
        } else {
          return o1.start - o2.start;
        }
      }); //按照start从小到大,然后end从大到小排序.
      for (int i = 0; i < intervals.length - 1; i++) {
        if (mark[i] != 1) {
          for (int j = i + 1; j < intervals.length; j++) {
            if (mark[j] == 1) {
              continue;
            } else {
              Interval left = intervals[i];
              Interval right = intervals[j];
              if (left.start == right.start) { //如果两个线段start一样,那么删掉end比较大的那个.
                mark[i] = 1;
                result++;
                break;
              } else if (left.end > right.start) { //如果两个线段有折叠
                result++;
                if (left.end <= right.end) { //如果右边的线段的end比较大,那么删掉右边线段,同时往后移动一位,继续比较下一个.
                  mark[j] = 1;
                } else {
                  mark[i] = 1; //如果左边的线段的end比较大,那么删掉左边的.同时结束内存循环.
                  break;
                }
              } else { // left.end <= right.start,因为已经排序了,那么后面的start必然都比left.end大,提前终止循环
                break;
              }
            }
          }
        }
      }
      return result;
    }
  }
}
