package leetcode;

import org.junit.Test;
import util.Assert;

public class _69_Sqrtx {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 0;
        while ( i * i <= x) {
            i++;
        }
        return i - 1;
    }

    @Test
    public void test() {
        _69_Sqrt q = new _69_Sqrt();
        Assert.assertEqual(3, q.mySqrt(9));
        Assert.assertEqual(2, q.mySqrt(8));
        Assert.assertEqual(46340, q.mySqrt(2147395600));
    }

}
