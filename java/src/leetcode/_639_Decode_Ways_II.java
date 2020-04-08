package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping
 * way: 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Beyond that, now the encoded string can also contain the
 * character '*', which can be treated as one of the numbers from 1 to 9. Given the encoded message
 * containing digits and the character '*', return the total number of ways to decode it. Also,
 * since the answer may be very large, you should return the output mod 109 + 7. Example 1: Input:
 * "*" Output: 9 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D",
 * "E", "F", "G", "H", "I". Example 2: Input: "1*" Output: 9 + 9 = 18
 *
 * @author jade on 2017/7/9 上午10:42
 */
public class _639_Decode_Ways_II {

  @Test
  public void test() {
    _639_Decode_Ways_II q = new _639_Decode_Ways_II();
    Assert.assertEquals(18, q.numDecodings("1*"));
    Assert.assertEquals(15, q.numDecodings("2*"));
    Assert.assertEquals(96, q.numDecodings("**"));
  }

  public int numDecodings(String s) {
    int mod = (int)1e9 + 9;
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '*' ? 9 : 1;
    for (int i = 2; i <= n; i++) {
      char c = s.charAt(i - 1);
      if (c == '*') {
        dp[i] += ((dp[i - 1] * 9) % mod);
        if (s.charAt(i - 2) == '1') {
          dp[i] += ((dp[i - 2] * 9) % mod);
        }else if (s.charAt(i - 2) == '2') {
          dp[i] += ((dp[i - 2] * 6) % mod);
        }else if (s.charAt(i - 2) == '*') {
          dp[i] += ((dp[i - 2] * 15) % mod);
        }
      }else {
        char pre = s.charAt(i - 2);
        if (pre == '*') {
          dp[i] += (dp[i - 1] % mod);
          if (c == '7' || c == '8' || c == '9') {
            dp[i] += (dp[i - 2] % mod);
          }else {
            dp[i] += ((dp[i - 2] * 2) % mod);
          }
        }else {
          if (pre == '0') {
            if (c == '0') {
              return 0;
            }
            dp[i] += (dp[i - 1] % mod);
          }else if (pre == '1') {
            dp[i] += (dp[i - 1] % mod);
            dp[i] += (dp[i - 2] % mod);
          }else if (pre == '2') {
            dp[i] += (dp[i - 1] % mod);
            if (c != '7' && c != '8' && c != '9') {
              dp[i] += (dp[i - 2] % mod);
            }
          }else {
            dp[i] += (dp[i - 1] % mod);
          }
        }
      }
    }
    return dp[n];
  }

}
