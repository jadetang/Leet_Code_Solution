package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.Assert;

public class _43_Multiply_Strings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> interValues = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String s = multiplyByOneDigit(num1, num2.charAt(i));
            s += "0".repeat(num2.length() - 1 -i);
            interValues.add(s);
        }
        String s = "0";
        for (String s1 : interValues) {
            s = add(s, s1);
        }
        return s;
    }

    String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int l = a.length() - 1;
        int r = b.length() - 1;
        int carry = 0;
        while (l >= 0 || r >= 0) {
            int lvalue = l < 0 ? 0 : a.charAt(l) - '0';
            int rvalue = r < 0 ? 0 : b.charAt(r) - '0';
            int value = lvalue + rvalue + carry;
            sb.append(value % 10);
            carry = value / 10;
            l--;
            r--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    String multiplyByOneDigit(String num, char c) {
        if (c == '0') {
            return "0";
        }
        int n  = c - '0';
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int temp = (num.charAt(i) - '0') * n + carry;
            sb.append(temp % 10);
            carry = temp / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        _43_Multiply_Strings q = new _43_Multiply_Strings();
        Assert.assertEqual("249",q.multiplyByOneDigit("83", '3'));
        Assert.assertEqual("86",q.add("83", "3"));
        Assert.assertEqual("3",q.add("0", "3"));
        Assert.assertEqual("13",q.add("5", "8"));
        Assert.assertEqual("121",q.multiply("11", "11"));
        Assert.assertEqual("0",q.multiply("0", "11"));
        Assert.assertEqual("110000011",q.multiply("10000001", "11"));
    }

}
