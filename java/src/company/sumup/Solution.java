package company.sumup;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public static Integer solution(Integer number) {
    return IntStream.range(0, number + 1).filter(i -> dividable(i, 3) || dividable(i, 5)).sum();
  }

  private static boolean dividable(int n, int d) {
    return n % d == 0;
  }


  public static String orderWeight(String strng) {
    return Arrays.stream(strng.split(" "))
        .sorted((s1, s2) -> {
          int weight1 = weight(s1);
          int weight2 = weight(s2);
          if (weight1 == weight2) {
            return s1.compareTo(s2);
          }
          return weight1 - weight2;

        })
        .collect(Collectors.joining(" "));
  }

  private static int weight(String string) {
    int weight = 0;
    for (char c : string.toCharArray()) {
      weight += Character.getNumericValue(c);
    }
    return weight;
  }

  public boolean isValid(String braces) {
    Stack<Character> stack = new Stack<>();
    for (char c : braces.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      }
      if (c == ']' || c == '}' || c == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        char preC = stack.pop();
        if (!match(preC, c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
    // Add code here
  }

  private boolean match(char left, char right) {
    return (left == '{' && right == '}') || (left == '[' && right == ']')
        || (left == '(' && right == ')');

  }

}
