package leetcode;

import org.junit.Test;
import util.Assert;

public class _161_One_Edit_Distance {

    @Test
    public void test() {
        _161_One_Edit_Distance q = new _161_One_Edit_Distance();
        Assert.assertTrue(q.isOneEditDistance("a","A"));
        Assert.assertTrue(q.isOneEditDistance("abc","ab"));
        Assert.assertTrue(q.isOneEditDistance("adc","abc"));
        Assert.assertTrue(q.isOneEditDistance("abbc","abc"));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int sL = s.length();
        int tL = t.length();
        if (tL - sL >= 2) {
            return false;
        }
        int i = 0;
        for ( ;i < sL; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }
        if (i == sL) {
            return tL == i + 1;
        }
        if (sL == tL) {
            return s.substring(i + 1).equals(t.substring(i + 1));
        }else {
            return s.substring(i).equals(t.substring(i + 1));
        }
    }
}
