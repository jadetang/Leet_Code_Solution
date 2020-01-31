package leetcode;

/**
 * @author jade on 2017/7/3 下午1:28
 */
public class _204_Count_Primes {

  public int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i * i < n; i++) {
      if (isPrime[i]) {
        // i 是质数的话，那么 i 的倍数就不是质数了
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;

  }
}
