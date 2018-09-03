package solution;

import java.util.PriorityQueue;

public class _703_Kth_Largest_ElementInAStream {

  PriorityQueue<Integer> pq = new PriorityQueue<>();

  private int k;

  public _703_Kth_Largest_ElementInAStream(int k, int[] nums) {
    this.k = k;
    if (nums.length > 0) {
      int i = 0;
      for (; i < Math.min(k, nums.length); i++) {
        pq.add(nums[i]);
      }
      for (; i < nums.length; i++) {
        if (nums[i] > pq.peek()) {
          pq.poll();
          pq.offer(nums[i]);
        }
      }
    }

  }

  public int add(int val) {
    if (pq.isEmpty() || pq.size() < k) {
      pq.offer(val);
      return pq.peek();
    }
    if (val > pq.peek()) {
      pq.poll();
      pq.offer(val);
    }
    return pq.peek();
  }

  public static void main(String[] args) {
    _703_Kth_Largest_ElementInAStream q = new _703_Kth_Largest_ElementInAStream(3,
        new int[]{4, 5, 8, 2});
    System.out.println(q.add(3));
    System.out.println(q.add(5));
    System.out.println(q.add(10));
    System.out.println(q.add(9));
    System.out.println(q.add(4));
  }

}
