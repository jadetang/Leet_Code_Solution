package lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1571_Top_K_GPA {


  public List<List<String>> topKgpa(List<List<String>> list, int k) {

    if (k > list.size()) {
      return list;
    }
    PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.naturalOrder());
    // Write your code here
    for (List<String> student : list) {
      Double gpa = Double.parseDouble(student.  get(1));
      if (queue.size() < k) {
        queue.add(gpa);
      } else {
        if (queue.peek() <= gpa) {
          queue.poll();
          queue.add(gpa);
        }
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> student : list) {
      if (Double.parseDouble(student.get(1)) >= queue.peek()) {
        result.add(student);
      }
    }
    return result;
  }


}
