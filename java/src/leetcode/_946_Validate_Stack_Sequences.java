package leetcode;

import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _946_Validate_Stack_Sequences {

    @Test
    public void test() {
        _946_Validate_Stack_Sequences q = new _946_Validate_Stack_Sequences();
        int[] pushed = new int[] {1,2,3,4,5};
        int[] popped = new int[] {4,5,3,2,1};
        Assert.assertTrue(q.validateStackSequences(pushed, popped));
    }

    @Test
    public void test2() {
        _946_Validate_Stack_Sequences q = new _946_Validate_Stack_Sequences();
        int[] pushed = new int[] {1,2,3,4,5};
        int[] popped = new int[] {4,3,5,1,2};
        Assert.assertFalse(q.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int j = 0; j < popped.length; j++) {
            int popNumber = popped[j];
            if (stack.isEmpty() || stack.peek() != popNumber) {
                while (i < pushed.length && (stack.isEmpty() || stack.peek() != popNumber)) {
                    stack.push(pushed[i]);
                    i++;
                }
            }
            if (stack.isEmpty() || stack.pop() != popNumber) {
                return false;
            }
        }
        return true;
    }
}
