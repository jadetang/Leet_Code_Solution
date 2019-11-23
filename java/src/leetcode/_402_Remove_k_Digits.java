package leetcode;

import java.util.Stack;

/**
 * @author jade on 16/9/19 上午9:07
 */
public class _402_Remove_k_Digits {

  public static void main(String[] args) {
    _402_Remove_k_Digits q = new _402_Remove_k_Digits();
    System.out.println("1".equals(q.removeKdigits("1000001", 1)));
    System.out.println("1".equals(q.removeKdigits("1234", 3)));
    System.out.println("1219".equals(q.removeKdigits("1432219", 3)));
    System.out.println("200".equals(q.removeKdigits("10200", 1)));
    System.out.println("0".equals(q.removeKdigits("10", 2)));
  }

  public String removeKdigits(String num, int k) {
    if (k >= num.length()) {
      return "0";
    } else if (k == 0) {
      return num;
    } else {
      int remain = num.length() - k;
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < num.length(); i++) {
        while (!stack.empty() && stack.peek() > num.charAt(i)
            && stack.size() + num.length() - i > remain) {
          stack.pop();
        }
        stack.push(num.charAt(i));
      }
      Stack<Character> resultStack = new Stack<>();
      while (!stack.empty()) {
        resultStack.push(stack.pop());
      }
      while (!resultStack.empty() && resultStack.peek() == '0') {
        resultStack.pop();
      }

      StringBuilder s = new StringBuilder();
      while (!resultStack.empty() && s.length() < remain) {
        s.append(resultStack.pop());
      }
      if (s.length() == 0) {
        s.append("0");
      }
      return s.toString();
    }
  }
}
