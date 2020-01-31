package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * @author jade on 2017/7/4 下午10:53
 */
public class _71_Simplify_Path {

  public static String simplifyPath(String path) {
    Deque<String> stack = new LinkedList<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
    for (String dir : path.split("/")) {
      if (dir.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (!skip.contains(dir)) {
        stack.push(dir);
      }
    }
    String res = "";
    for (String dir : stack) {
      res = "/" + dir + res;
    }
    return res.isEmpty() ? "/" : res;
  }

  public static String simplifyPath2(String path) {
    Stack<String> stack = new Stack<>();
    for (String p : path.split("/")) {
      if (p.equals(".") || p.equals("")) {
        continue;
      } else if (p.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(p);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (String p : stack) {
      sb.append("/" + p);
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/..."));
    System.out.println(simplifyPath2("/..."));
  }
}
