package company;

import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Solution {

  public int solution(String s) {
    s = eat(s, 'C');
    s = eat(s, 'B');
    s = eat(s, 'A');
    return s.length();
  }

  public String eat(String fishes, char currentFish) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < fishes.length(); i++) {
      char c = fishes.charAt(i);
      if (c != currentFish) {
        stack.push(c);
      } else {
        while (!stack.isEmpty() && canEat(currentFish, stack.peek())) {
          stack.pop();
        }
        while (i + 1 < fishes.length() && canEat(currentFish, fishes.charAt(i + 1))) {
          i++;
        }
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  private boolean canEat(char firstFish, char secondFish) {
    if (firstFish == 'A' && (secondFish == 'B' || secondFish == 'C')) {
      return true;
    } else if (firstFish == 'B' && (secondFish == 'C' || secondFish == 'D')) {
      return true;
    } else if (firstFish == 'C' && secondFish == 'D') {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    ExecutorService service = Executors.newSingleThreadExecutor();
    System.out.println(s.solution("ABAD"));
    System.out.println(s.solution("ACCDDA"));
    System.out.println(s.solution(""));
  }
}