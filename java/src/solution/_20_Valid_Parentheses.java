package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sanguan.tangsicheng on 2017/7/1 下午12:16
 */
public class _20_Valid_Parentheses {

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('{');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();

  }

}
