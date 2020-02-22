package leetcode;

import org.junit.Test;
import util.Assert;

public class _168_Excel_Sheet_Column_Title {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int re = n % 26;
            sb.append((char)('A' + re));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        _168_Excel_Sheet_Column_Title q = new _168_Excel_Sheet_Column_Title();
        Assert.assertEqual("Z",q.convertToTitle(26));
        Assert.assertEqual("AA",q.convertToTitle(27));
    }

}
