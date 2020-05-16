package leetcode;

import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _227_Basic_Calculator_II {

    @Test
    public void test() {
        _227_Basic_Calculator_II q = new _227_Basic_Calculator_II();
        Assert.assertEqual(5, q.calculate("1 + 4"));
        Assert.assertEqual(10, q.calculate("1 + 3 * 3"));
        Assert.assertEqual(1, q.calculate(" 3/2 "));
        Assert.assertEqual(46, q.calculate("46"));
    }

    @Test
    public void test2() {
        _227_Basic_Calculator_II q = new _227_Basic_Calculator_II();
        //  Assert.assertEqual(3, q.calculate("6 / 2"));
        Assert.assertEqual(4, q.calculate("1 + 6 / 2"));
    }

    public int calculate(String s) {
       Stack<Integer> stack = new Stack<>();
       char sign = '+';
       int num = 0;
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (Character.isDigit(c)) {
               num = num * 10 + Character.getNumericValue(c);
           }
           if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
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
               }
               sign = c;
               num = 0;
           }
       }
       return stack.stream().reduce(Integer::sum).get();
    }
}
