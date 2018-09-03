package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jade on 2017/7/2 下午7:16
 */
public class _150_Evaluate_Reverse_Polish_Notation {


  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String s : tokens) {
      if (s.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (s.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (s.equals("/")) {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second / first);
      } else if (s.equals("-")) {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second - first);
      } else {
        stack.push(Integer.parseInt(s));
      }

    }
    return stack.pop();
  }
}
