package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _901_Online_Stock_Span {

  Deque<Integer> prices, weights;


  public _901_Online_Stock_Span() {
    prices = new ArrayDeque<>();
    weights = new ArrayDeque<>();
  }

  public int next(int price) {
    int w = 1;
    while (!prices.isEmpty() && prices.peek() <= price) {
      prices.pop();
      w += weights.pop();
    }
    prices.push(price);
    weights.push(w);
    return w;
  }


}
