package solution;

import static org.junit.Assert.*;

import org.junit.Test;

public class _1249_Minimum_Remove_to_Make_Valid_ParenthesesTest {

    _1249_Minimum_Remove_to_Make_Valid_Parentheses q = new _1249_Minimum_Remove_to_Make_Valid_Parentheses();

    @Test
    public void test1() {
        assertEquals("", q.minRemoveToMakeValid(")("));
    }

    @Test
    public void test2() {
        assertEquals("()", q.minRemoveToMakeValid("()"));
    }

    @Test
    public void test3() {
        assertEquals("", q.minRemoveToMakeValid("))(((("));
    }

    @Test
    public void test4() {
        assertEquals("((leetcode))", q.minRemoveToMakeValid("((leetcode)))"));
    }

    @Test
    public void test5() {
        assertEquals("a(b(c)d)", q.minRemoveToMakeValid("(a(b(c)d)"));
    }

}