package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/13 下午10:40
 */
public class _343_Integer_Break {


    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        _343_Integer_Break q = new _343_Integer_Break();
        System.out.println(q.integerBreak(10));
        System.out.println(q.integerBreak(11));
        System.out.println(q.integerBreak(12));
    }
}
