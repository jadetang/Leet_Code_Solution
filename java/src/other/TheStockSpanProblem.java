package other;

import java.util.Deque;
import java.util.LinkedList;
import util.Util;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class TheStockSpanProblem {

  public static int[] stockPrice(int[] price) {
    int[] result = new int[price.length];
    result[0] = 1;
    Deque<Integer> deque = new LinkedList<>();
    deque.offer(0);
    for (int i = 1; i < price.length; i++) {
      while (!deque.isEmpty() && price[deque.peek()] <= price[i]) {
        deque.poll();
      }
      if (deque.isEmpty()) {
        result[i] = i + 1;
      } else {
        result[i] = i - deque.peek();
      }
      deque.push(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] price = new int[]{100, 80, 60, 70, 60, 75, 85};
    Util.print(stockPrice(price));
  }
}
