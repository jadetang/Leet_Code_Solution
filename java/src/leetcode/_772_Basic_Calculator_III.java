package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _772_Basic_Calculator_III {

    @Test
    public void test() {
        _772_Basic_Calculator_III q = new _772_Basic_Calculator_III();
        Assert.assertEqual(5, q.calculate("1 * (2 + 3)"));
        Assert.assertEqual(-12 ,q.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
        Assert.assertEqual(2 ,q.calculate("(2)"));
    }

    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }
        return calculate(queue);
    }

    private int calculate(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(queue);
            }
            if ( c == '*' || c == '/' || c == '+' || c == '-' || c == ')' || queue.isEmpty()) {
                int pre = 0;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if ( c == ')') {
                break;
            }
        }
        return stack.stream().reduce(Integer::sum).get();
    }
}
