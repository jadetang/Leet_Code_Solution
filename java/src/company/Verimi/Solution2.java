package company.Verimi;

import java.util.Arrays;
import java.util.List;

public class Solution2 {

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 6, 10, 16);
    List<Integer> list2 = Arrays.asList(2);
    System.out.println(requestsServed(list1, list2));

  }

  public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
    // Write your code here
    int[] request = timestamp.stream().mapToInt(Integer::intValue).toArray();
    boolean[] severed = new boolean[request.length];
    Arrays.fill(severed, false);
    int ans = 0;

    for (Integer priorityTime : top) {
      int startPoint = Arrays.binarySearch(request, priorityTime);

      startPoint = startPoint < 0 ? Math.abs(startPoint) - 2 : startPoint;
      int i = 0;
      while (i < 5 && startPoint >= 0) {
        if (severed[startPoint]) {
          startPoint--;
        } else {
          severed[startPoint] = true;
          startPoint--;
          i++;
          ans++;
        }
      }
    }
    return ans;
  }


}
