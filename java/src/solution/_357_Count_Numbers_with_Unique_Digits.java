package solution;

/**
 * @author jade on 2016/11/13 下午5:34
 */
public class _357_Count_Numbers_with_Unique_Digits {


  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    } else {
      int result = 0;
      for (int i = 1; i <= n; i++) {
        result += count(i);
      }
      return result;

    }
  }

  private int count(int k) {
    if (k == 1) {
      return 10;
    } else if (k > 10) {
      return count(10);
    } else {
      int result = 9;
      int factor = 9;
      for (int i = 1; i <= k - 1; i++) {
        result = result * factor;
        factor--;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    _357_Count_Numbers_with_Unique_Digits q = new _357_Count_Numbers_with_Unique_Digits();
    System.out.println(q.countNumbersWithUniqueDigits(2));
  }

}
