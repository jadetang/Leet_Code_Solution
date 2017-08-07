package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * @author sanguan.tangsicheng on 16/9/30 上午8:57
 */
public class _32_Longest_Valid_Parentheses {

    public static void main(String[] args) {

        test("()");
        test(")(");
        test("(()");
        test("(())");
        test(")(())(");
        test("(");
        test("())");
        test("()(()");
        test("()()");

    }

    private static void test(String s) {
        _32_Longest_Valid_Parentheses q = new _32_Longest_Valid_Parentheses();
        int result = q.longestValidParentheses3(s);
        System.out.println(s + ":" + result);
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public int longestValidParentheses3(String s){
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                max = Math.max(max,2*left);
            }else if (right >= left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for ( int i = s.length()-1; i >=0 ; i--){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                max = Math.max(max,2*left);
            }else if (left>=right){
                left =0;
                right = 0;
            }

        }
        return max;
    }




    public int longestValidParentheses(String s) {

        int n = s.length();
        int longest = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }

        }
        if (stack.isEmpty()) {
            return n;
        } else {
            int a = n;
            int b = 0;
            while (!stack.isEmpty()) {
                b = stack.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }
}
