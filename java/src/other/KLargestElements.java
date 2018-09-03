package other;

import java.util.PriorityQueue;
import util.Util;

/**
 * https://practice.geeksforgeeks.org/problems/k-largest-elements/0
 *
 * Given an array, print k largest elements from the array.  The output elements should be printed
 * in decreasing order.
 *
 * Input:
 *
 * The first line of input contains an integer T denoting the number of test cases. The first line
 * of each test case is N and k, N is the size of array and K is the largest elements to be
 * returned. The second line of each test case contains N input C[i].
 *
 * Output:
 *
 * Print the k largest element in descending order.
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 100 1 ≤ N ≤ 100 K ≤ N 1 ≤ C[i] ≤ 1000
 *
 * Example:
 *
 * Input: 2 5 2 12 5 787 1 23 7 3 1 23 12 9 30 2 50
 *
 * Output: 787 23 50 30 23
 */
public class KLargestElements {

  public static int[] kLarge(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
    for (int num : nums) {
      if (priorityQueue.size() < k) {
        priorityQueue.add(num);
      } else {
        if (priorityQueue.peek() < num) {
          priorityQueue.poll();
          priorityQueue.add(num);
        }
      }
    }
    return priorityQueue.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int[] result = kLarge(new int[]{1, 23, 12, 9, 30, 2, 50}, 3);
    Util.print(result);
  }

}
