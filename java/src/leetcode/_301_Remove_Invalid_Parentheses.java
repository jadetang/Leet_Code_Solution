package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.Assert;

/**
 * @author jade on 2017/5/21 下午5:44
 */

public class _301_Remove_Invalid_Parentheses {

    List<String> ans = new ArrayList<>();

    char[] chars;

    boolean[] removed;

    public List<String> removeInvalidParentheses(String s) {
        int[] parenthesesToRemove = calculateRemove(s);
        int leftToRemove = parenthesesToRemove[0];
        int rightToRemove = parenthesesToRemove[1];
        chars = s.toCharArray();
        removed = new boolean[chars.length];
        dfs(0, leftToRemove, rightToRemove);
        return ans;
    }

    private void dfs(int index, int left, int right) {
        if (left == 0 && right == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < chars.length; i++){
                    if (!removed[i]) {
                        sb.append(chars[i]);
                    }
                }
                if (isValid(sb.toString())) {
                    ans.add(sb.toString());
                }

        } else {
            for (int i = index; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == ')') {
                    if (i > 0 && chars[i] == chars[i - 1] && !removed[i]) {
                        continue;
                    }
                    removed[i] = true;
                    if (left > 0 && chars[i] == '(') {
                        dfs( i + 1, left - 1, right);
                    }
                    if (right > 0 && chars[i] == ')') {
                        dfs( i + 1, left , right - 1);
                    }
                    removed[i] = false;
                }
            }
        }
    }

    private String remove(String s, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            if (j != i) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
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
            } else if (c == ')') {
                if (left == 0) {
                    rightToRemove++;
                } else {
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

