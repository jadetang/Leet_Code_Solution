package leetcode;

import org.junit.Test;
import util.Assert;

public class _69_Sqrtx {

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 0;
        while ( i * i <= x) {
            i++;
        }
        return i - 1;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 1;
        long r = x;
        while (l < r) {
            long m = l + (r - l) / 2;
            long square = m * m;
            if (square == x) {
                return (int) m;
            }else if (square < x) {
                l = m;
            }else {
                r = m - 1;
            }
        }
        return (int)(l - 1);
    }

    @Test
    public void test() {
        _69_Sqrt q = new _69_Sqrt();
        Assert.assertEqual(3, q.mySqrt(9));
        Assert.assertEqual(2, q.mySqrt(8));
        Assert.assertEqual(46340, q.mySqrt(2147395600));
        Assert.assertEqual(46339, q.mySqrt(2147395599));
    }

}
