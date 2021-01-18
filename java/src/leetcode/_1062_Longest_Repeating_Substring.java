package leetcode;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _1062_Longest_Repeating_Substring {

    @Test
    public void test() {
        var q = new _1062_Longest_Repeating_Substring();
        Assert.assertEqual(0, q.longestRepeatingSubstring("abcd"));
    }
    public int longestRepeatingSubstring(String s) {
        int l = 1;
        int r = s.length() + 1;
        while (l < r) {
            int mid = l + (r  - l) / 2;
            if (noRepeating(mid,s)) {
                r = mid;
            }else {
                l = l + 1;
            }
        }
        return l - 1;
    }

    private boolean noRepeating(int length, String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i + length <= s.length(); i++) {
            String sub = s.substring(i, i + length);
            if (set.contains(sub)) {
                return false;
            }
            set.add(sub);
        }
        return true;
    }
}
