package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _273_Integer_To_English_Word {

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16,"Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num < 1000){
            return covert(num);
        }else {
            return null;
        }
    }

    /**
     0 - 999  to string
     */
    String covert(int num) {
        if (num == 0) {
            return "Zero";
        }
        int lastDigit = num % 10;
        int secondDigit = (num % 100) / 10;
        int firstDigit = (num / 100);
        StringBuilder sb = new StringBuilder();
        if (firstDigit != 0) {
            sb.append(map.get(firstDigit) + " ");
            sb.append("Hundred ");
        }
        if (secondDigit != 0) {
            if (lastDigit == 0 || secondDigit == 1) {
                sb.append(map.get(secondDigit * 10 + lastDigit));
            }else {
                sb.append(map.get(secondDigit * 10) + " ");
                sb.append(map.get(lastDigit));
            }
        }else {
            sb.append(map.get(lastDigit));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        _273_Integer_To_English_Word q = new _273_Integer_To_English_Word();
        Assert.assertEqual("One Hundred Twelve", q.numberToWords(112));
        Assert.assertEqual("One Hundred Twenty", q.numberToWords(120));
        Assert.assertEqual("Nine Hundred Twenty One", q.numberToWords(921));
    }
}
