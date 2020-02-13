package leetcode;

import org.junit.Test;
import util.Assert;

public class _67_Add_Binary {

    @Test
    public void test() {
        _67_Add_Binary q = new _67_Add_Binary();
        Assert.assertEqual("10000",q.addBinary("1111", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int left = i >= 0 ? a.charAt(i) - '0' : 0;
            i--;
            int right = j >= 0 ? b.charAt(j) - '0' : 0;
            j--;
            sb.append( (left + right + carry) & 1);
            carry = (left + right + carry) >> 1;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}