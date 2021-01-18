/*
package company.google;

import ds.Interval;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.junit.Test;

public class MergeIntervalWithLabels {

  @Test
  public void test() {
    Interval[] intervals = new Interval[] {new Interval(0, 3), new Interval(0, 3), new Interval(2, 4), new Interval(5, 6)};
    String[] labels = new String[] {"A", "B", "C", "D"};
    MergeIntervalWithLabels mergeIntervalWithLabels = new MergeIntervalWithLabels();
    System.out.println(mergeIntervalWithLabels.merge(intervals, labels));
  }

  @Test
  public void test2() {
    Interval[] intervals = new Interval[] {new Interval(0, 4), new Interval(1, 5)};
    String[] labels = new String[] {"A", "A"};
    MergeIntervalWithLabels mergeIntervalWithLabels = new MergeIntervalWithLabels();
    System.out.println(mergeIntervalWithLabels.merge(intervals, labels));
  }

  public List<String> merge(Interval[] intervals, String[] labels) {
    TreeMap<Integer, List<Event>> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.computeIfAbsent(intervals[i].start, k -> new ArrayList<>() ).add(new Event(true, labels[i]));
      map.computeIfAbsent(intervals[i].end, k -> new ArrayList<>() ).add(new Event(false, labels[i]));
    }
    LinkedHashSet<String> labelsSet = new LinkedHashSet<>();
    Integer lastPoint = null;
    List<String> ans = new ArrayList<>();
    for (Entry<Integer, List<Event>> entry : map.entrySet()) {
      if (labelsSet.isEmpty()) {
        lastPoint = entry.getKey();
        for (Event event : entry.getValue()) {
          labelsSet.add(event.label);
        }
      }else {
        if (ignore(entry.getValue(), labelsSet)) {
          continue;
        }
        ans.add(String.format("[%d, %d,] {%s}", lastPoint, entry.getKey(), labelsSet.toString()));
        entry.getValue().stream().filter(event -> !event.start)
            .forEach(event -> labelsSet.remove(event.label));
        entry.getValue().stream().filter(event -> event.start)
            .forEach(event -> labelsSet.remove(event.label));
        lastPoint = entry.getKey();
      }
    }
    return ans;
  }

  private boolean ignore(List<Event> value, LinkedHashSet<String> labelsSet) {
    List<Event> startEvent = value.stream()
  }

  public static class Event  {

    boolean start;

    String label;

    public Event(boolean start, String label) {
      this.start = start;
      this.label = label;
    }
  }

}
*/
