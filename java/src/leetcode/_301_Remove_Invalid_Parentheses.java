package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import util.Assert;


/**
 * @author jade on 2017/5/21 下午5:44
 */

public class _301_Remove_Invalid_Parentheses {

    char[] chars;

    int leftToRemove;

    int rightToRemove;

    int n;

    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.chars = s.toCharArray();
        this.n = chars.length;
        int[] parenthesesToRemove = calculateRemove(s);
        this.leftToRemove = parenthesesToRemove[0];
        this.rightToRemove = parenthesesToRemove[1];
        if (leftToRemove == 0 && rightToRemove == 0) {
            ans.add(s);
            return new ArrayList<>(ans);
        }
        dfs(new StringBuilder(), 0, 0, 0);
        return new ArrayList<>(ans);
    }

    private void dfs(StringBuilder sb, int index, int removedLeft, int removedRight) {
        if (index == n) {
            if (removedLeft == leftToRemove && removedRight == rightToRemove && isValid(sb.toString())){
                ans.add(sb.toString());
            }
        }else {
            char c = chars[index];
            if (c == '(') {
                if (removedLeft < leftToRemove) {
                    dfs(new StringBuilder(sb.toString()), index + 1, removedLeft + 1, removedRight);
                }
                dfs(new StringBuilder(sb.toString()).append(c), index + 1, removedLeft, removedRight);
            }else if (c == ')') {
                if (removedRight < rightToRemove) {
                    dfs(new StringBuilder(sb.toString()), index + 1, removedLeft, removedRight + 1);
                }
                dfs(new StringBuilder(sb.toString()).append(c), index + 1, removedLeft, removedRight);
            }else {
                dfs(new StringBuilder(sb.toString()).append(c), index + 1, removedLeft, removedRight);
            }
        }
    }

    private boolean isValid(String s) {
        int[] a = calculateRemove(s);
        return a[0] == 0 && a[1] == 0;
    }


    private int[] calculateRemove(String s) {
        int left = 0;
        int rightToRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }else if (c == ')') {
                if (left == 0) {
                    rightToRemove++;
                }else {
                    left--;
                }
            }
        }
        return new int[]{left, rightToRemove};
    }

    @Test
    public void test1() {
        _301_Remove_Invalid_Parentheses a = new _301_Remove_Invalid_Parentheses();
        String s = "())";
        List<String> ans = a.removeInvalidParentheses(s);
        System.out.println(ans);
        Assert.assertEqual(1, ans.size());
    }

    @Test
    public void test2() {
        _301_Remove_Invalid_Parentheses a = new _301_Remove_Invalid_Parentheses();
        String s = "()())()";
        List<String> ans = a.removeInvalidParentheses(s);
        System.out.println(ans);
        Assert.assertEqual(2, ans.size());
    }
}

