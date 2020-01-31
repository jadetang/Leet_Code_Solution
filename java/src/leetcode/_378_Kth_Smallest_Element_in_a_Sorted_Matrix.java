package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jade on 2016/11/15 下午10:07
 */
public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(
        (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1));

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (q.size() >= k && q.peek() > matrix[i][j]) {
          q.poll();
          q.add(matrix[i][j]);
        } else if (q.size() < k) {
          q.add(matrix[i][j]);
        } else {
          continue;
        }

      }
    }
    return q.peek();


  }


}
