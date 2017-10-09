package solution;

import java.util.LinkedList;

import util.Util;

/**
 * @author sanguan.tangsicheng on 2017/7/5 下午11:01
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

  public static void main(String[] args) {
    int[] a = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
    int[] res = maxSlidingWindow(a, 5);
    Util.print(res);
  }

}
