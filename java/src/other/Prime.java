package other;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2016/11/27 下午11:55
 */
public class Prime {

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    int length = (int) Math.sqrt(n);
    for (int i = 3; i < length; i += 2) {
      if (n % i == 0) {
        return true;
      }
    }
    return false;
  }

  public static List<Integer> erotosthenes(int n) {
    List<Integer> result = new LinkedList<>();
    if (n <= 1) {
      return result;
    }
    BitSet bit = new BitSet(n + 1);
    int length = (int) Math.sqrt(n);
    bit.set(1);
    for (int i = 2; i < length; i++) {
      if (!bit.get(i)) {
        for (int j = i * i; j < n; j += i) {
          bit.set(j);
        }
      }
    }
    for (int i = 1; i < n; ) {
      i = bit.nextClearBit(i + 1);
      result.add(i);
    }
    return result;
  }


  public static List<Integer> primeFactors(int n) {
    List<Integer> result = new LinkedList<>();
    int length = (int) Math.sqrt(n);
    for (int i = 2; i <= length; i++) {
      while (n % i == 0) {
        result.add(i);
        n /= i;
      }
    }
    if (n > 1) {
      result.add(n);
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println(isPrime(1337));
  }
}
