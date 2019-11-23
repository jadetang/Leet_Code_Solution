package leetcode;

import ds.Interval;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author jade on 2016/12/5 上午12:21
 */
public class _352_Data_Stream_as_Disjoint_Intervals {


  public static void main(String[] args) {
    SummaryRanges s = new SummaryRanges();
    s.addNum(1);
    s.addNum(3);
    s.addNum(7);
    s.addNum(2);
    s.addNum(6);
    System.out.println(s.getIntervals());
    // System.out.println(s.getIntervals());

  }

  public static class SummaryRanges {

    TreeSet<Interval> data;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
      data = new TreeSet<>((Comparator<Interval>) (o1, o2) -> o1.start - o2.start);
    }

    public void addNum(int val) {

      Interval interval = new Interval(val, val);
      Interval floor = data.floor(interval);
      if (floor != null) {
        if (floor.end >= val) {
          return;
        } else if (floor.end == val - 1) {
          interval.start = floor.start;
          data.remove(floor);
        }
      }
      Interval higher = data.higher(interval);
      if (higher != null && higher.start == val + 1) {
        interval.end = higher.end;
        data.remove(higher);
      }
      data.add(interval);

    }

    public List<Interval> getIntervals() {
      return Arrays.asList(data.toArray(new Interval[0]));
    }
  }
}
