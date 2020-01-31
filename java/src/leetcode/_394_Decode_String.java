package leetcode;

import java.util.Stack;

/**
 * @author jade on 2016/11/17 下午10:10
 */
public class _394_Decode_String {

  public static void main(String[] args) {
    _394_Decode_String q = new _394_Decode_String();
    System.out.println(q.decodeString("2[2[b]]"));
  }

  public String decodeString(String s) {
    //StringBuilder sb = new StringBuiler();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != ']') {
        stack.push(c);
      } else {
        StringBuilder sb = new StringBuilder();
        Character tempChar;
        while ((tempChar = stack.pop()) != '[') {
          sb.insert(0, tempChar);
        }
        int base = 0;
        int repeat = 0;
        while (!stack.empty() && Character.isDigit(stack.peek())) {
          repeat += (stack.pop() - '0') * Math.pow(10, base++);
        }
        for (int j = 0; j < repeat; j++) {
          for (Character ch : sb.toString().toCharArray()) {
            stack.push(ch);
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    return sb.toString();
  }
}
