package leetcode;

import java.util.stream.LongStream;
import org.junit.Test;
import util.Assert;

public class _552_Student_Attendance_Record_II {

    @Test
    public void test() {
        _552_Student_Attendance_Record_II q = new _552_Student_Attendance_Record_II();
        Assert.assertEqual(8, q.checkRecord(2));
    }

    @Test
    public void test2() {
        _552_Student_Attendance_Record_II q = new _552_Student_Attendance_Record_II();
        Assert.assertEqual(19, q.checkRecord(3));
    }

    @Test
    public void test3() {
        _552_Student_Attendance_Record_II q = new _552_Student_Attendance_Record_II();
        Assert.assertEqual(43, q.checkRecord(4));
    }

    @Test
    public void test4() {
        _552_Student_Attendance_Record_II q = new _552_Student_Attendance_Record_II();
        Assert.assertEqual(985598218, q.checkRecord(100));
    }

    int l = 0;
    int p = 1;
    int ll = 2;
    int al = 3;
    int ap = 4;
    int all = 5;
    int a = 6;
    int mod = 1_000_000_007;

    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }
        long[][] dp = new long[n + 1][7];
        dp[1][l] = 1;
        dp[1][p] = 1;
        dp[1][ll] = 0;
        dp[1][al] = 0;
        dp[1][ap] = 0;
        dp[1][all] = 0;
        dp[1][a] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][l] = dp[i - 1][p] % mod;
            dp[i][al] = (dp[i - 1][a] % mod + dp[i - 1][ap] % mod) % mod;
            dp[i][p] = (dp[i - 1][p] % mod + dp[i - 1][l] % mod + dp[i - 1][ll] % mod) % mod;
            dp[i][ap] = (dp[i - 1][ap] % mod + dp[i - 1][al] % mod + dp[i - 1][all] % mod + dp[i - 1][a] % mod) % mod;
            dp[i][ll] = dp[i - 1][l] % mod;
            dp[i][all] = dp[i - 1][al] % mod;
            dp[i][a] = (dp[i - 1][l] % mod + dp[i - 1][p] % mod + dp[i - 1][ll] % mod) % mod;
        }
        return (int) (LongStream.of(dp[n]).map(i -> i % mod).sum() % mod);
    }
}
