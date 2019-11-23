package util;

public class Test {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      isPrime(10);
    }
    System.out.println(System.currentTimeMillis() - startTime);
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      isPrime3(10);
    }
    System.out.println(System.currentTimeMillis() - startTime);
  }


  public static boolean isPrime(int n) {
    if (n <= 3) {
      return n > 1;
    }
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrime2(int n) {
    if (n <= 3) {
      return n > 1;
    }
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrime3(int n) {
    if (n <= 3) {
      return n > 1;
    }
    boolean[] flag = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
      if (!flag[i]) {
        if (isPrime(i)) {
          for (int j = i; j <= n; j += i) {
            flag[i] = true;
          }
        }
      }
    }
    return flag[n];
  }


/*

  public static boolean isPrime2(int n) {
    if (n <= 3) {
      return n > 1;
    }
    int sqrt = (int) Math.sqrt(n);
    boolean[] flag = new boolean[sqrt+1];
    for (int i = 2; i <= sqrt; i++) {
      if ( !flag[i]){
        if (n % i == 0) {
          return false;
        }else {
          flag[i] = true;
          for ( int j = i ; j <= sqrt; j+=i){
            flag[j] = true;
          }
        }
      }
    }
    return true;
  }
*/


}
