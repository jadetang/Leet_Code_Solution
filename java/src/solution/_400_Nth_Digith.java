package solution;

/**
 * @author jade on 2016/11/12 下午3:33
 */
public class _400_Nth_Digith {

  public int findNthDigit(int n) {
    // For 1, 2 .., 9, return the result directly
    if (n <= 9) {
      return n;
    }

    int base = 1;

    // Determine the range
    // 10, 11, ..., 99:  90 * 2 digits in total, base = 2
    // 101, 102, 103, ..., 999:  900 * 3  digits in total, base = 3
    // ...
    while (n > 9 * Math.pow(10, base - 1) * base) {
      n = n - 9 * (int) Math.pow(10, base - 1) * base;
      base++;
    }

    // Now we should find out which number the answer follows. eg. if the input is 15, the answer should follow on number "12", that's the variable number for.
    int number = (int) Math.pow(10, base - 1) + (n - 1) / base;

    // Then we should find out which specific in the number "12". that's what index for, for input 15, index = 0
    int index = (n - 1) % base;

    // The answer is the index-th digit of the variable number
    return Integer.toString(number).charAt(index) - '0';
  }

  public static void main(String[] args) {
    _400_Nth_Digith q = new _400_Nth_Digith();
    System.out.println(q.findNthDigit(11));
  }
}
