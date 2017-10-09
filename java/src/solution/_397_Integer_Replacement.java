package solution;

import java.util.Arrays;

/**
 * @author sanguan.tangsicheng on 2016/11/27 下午5:12
 */
public class _397_Integer_Replacement {

  int dp[];

  public int integerReplacement(int n) {
    dp = new int[n + 2];
    Arrays.fill(dp, -1);
    dp[1] = 0;
    dp[2] = 1;
    return help(dp, n);
  }

  private int help(int[] dp, int n) {
    if (dp[n] != -1) {
      return dp[n];
    } else {
      if (n % 2 == 0) {
        dp[n] = 1 + help(dp, n / 2);
      } else {
        dp[n] = 1 + Math.min(help(dp, n - 1), help(dp, n + 1));
      }
      return dp[n];
    }
  }

  public int integerReplacement2(int n) {
    int cnt = 0;
    while (n != 1) {
      cnt++;
      if ((n & 1) == 0) {
        n >>>= 1;
      } else if (n == 3 || (n & 2) == 0) {
        n -= 1;
      } else {
        n += 1;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    _397_Integer_Replacement q = new _397_Integer_Replacement();
    System.out.println(q.integerReplacement(100000000));
    System.out.println(q.integerReplacement2(100000000));
  }
}
