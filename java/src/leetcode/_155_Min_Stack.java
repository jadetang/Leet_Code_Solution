package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jade on 2017/7/2 下午9:49
 */
public class _155_Min_Stack {

  Deque<Integer> stack;
  Deque<Integer> minStack;

  /**
   * initialize your data structure here.
   */
  public _155_Min_Stack() {
    this.stack = new ArrayDeque<>();
    this.minStack = new ArrayDeque<>();
  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || minStack.peek() >= x) {
      minStack.push(x);
    }
  }

  public void pop() {
    int x = stack.pop();
    if (x == minStack.peek()) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

}
