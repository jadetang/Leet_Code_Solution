package leetcode;

import java.util.Stack;

public class _1209_Remove_All_Adjacent_Duplicates_in_String_II {

  public String removeDuplicates(String s, int k) {
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Pair currentPair = new Pair(s.charAt(i), 1);
      if (!stack.empty() && stack.peek().c == currentPair.c) {
        stack.peek().count += currentPair.count;
        if (stack.peek().count >= k) {
          stack.pop();
        }
      } else {
        stack.push(currentPair);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Pair pair : stack) {
      while (pair.count > 0) {
        sb.append(pair.c);
        pair.count--;
      }
    }
    return sb.toString();
  }

  public static class Pair {

    char c;
    int count;

    public Pair(char c, int count) {
      this.c = c;
      this.count = count;
    }
  }
}
