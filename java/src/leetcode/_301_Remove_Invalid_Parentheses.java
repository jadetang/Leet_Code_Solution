/*
package leetcode;

import java.util.List;
import java.util.Stack;

*/
/**
 * @author jade on 2017/5/21 下午5:44
 *//*

public class _301_Remove_Invalid_Parentheses {



    public List<String> removeInvalidParentheses(String s) {
        Character  p = invalidParentheses(s);
        return null;
    }


    public int invalidParentheses(String s){

        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()){
            if ( c == '('){
                stack.push(c);
            }else {
                if (c == ')') {
                    if (stack.isEmpty()) {
                        return c;
                    } else {
                        Character pop = stack.pop();
                        if (pop == ')') {
                            return c;
                        }
                    }

                }
            }
        }
        if (!stack.isEmpty()){
            return stack.pop();
        }else {
            return ' ';
        }
    }

    public static void main(String[] args) {
        _301_Remove_Invalid_Parentheses r = new _301_Remove_Invalid_Parentheses();
        testInvalidParentheses(r);
    }

    private static void testInvalidParentheses(_301_Remove_Invalid_Parentheses r) {
        System.out.println(r.invalidParentheses("()())()"));
        System.out.println(r.invalidParentheses("(a)())()"));
        System.out.println(r.invalidParentheses(")("));
        System.out.println(r.invalidParentheses("()("));
        System.out.println(r.invalidParentheses("(()"));

    }

}
*/
