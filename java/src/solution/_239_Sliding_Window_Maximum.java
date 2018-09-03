package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import java.util.List;
import util.Util;

/** https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * @author jade on 2017/7/5 下午11:01
 */
public class _239_Sliding_Window_Maximum {

  public static int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<int[]> list = new LinkedList<>();

    for (int i = 0; i < k - 1; i++) {
      while (!list.isEmpty() && list.getFirst()[0] < nums[i]) {
        list.removeFirst();
      }
      list.addFirst(new int[]{nums[i], i});
    }

    int[] rest = new int[nums.length - k + 1];
    for (int i = k - 1; i < nums.length; i++) {
      while (!list.isEmpty() && list.getFirst()[0] < nums[i]) {
        list.removeFirst();
      }
      list.addFirst(new int[]{nums[i], i});
      while (list.getLast()[1] < i - k + 1) {
        list.removeLast();
      }
      rest[i - k + 1] = list.getLast()[0];

    }
    return rest;
  }

  public static int[] maxSlidingWindow2(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    int i = 0;
    for ( ; i < k; i++){
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
        deque.removeLast();
      }
      deque.addLast(i);
    }
    for ( ; i < nums.length; i++ ){
      result.add(deque.peek());
      while (!deque.isEmpty() && deque.peek() <= i - k ){
        deque.removeFirst();
      }
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
        deque.removeLast();
      }
      deque.addLast(i);
    }
    result.add(deque.peek());
    return result.stream().mapToInt( r->nums[r]).toArray();
  }


  public static void main(String[] args) {
    int[] a = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
    int[] res = maxSlidingWindow(a, 5);
    int[] res2 = maxSlidingWindow2(a, 5);
    Util.print(res);
    Util.print(res2);
  }

}
