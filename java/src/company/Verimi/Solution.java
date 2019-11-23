package company.Verimi;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {


  public static int minSum(List<Integer> num, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    queue.addAll(num);

    int i = 0;
    while (i < k) {
      int maxValue = queue.poll();
      queue.offer(calculate(maxValue));
      i++;
    }

    return queue.stream().reduce(Integer::sum).get();

  }

  private static int calculate(int value) {
    if (value == 0) {
      return 0;
    }
    return (value + 1) / 2;
  }

}
