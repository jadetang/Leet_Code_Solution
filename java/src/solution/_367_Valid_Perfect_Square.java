package solution;

/**
 * @author sanguan.tangsicheng on 2016/12/3 上午12:37
 */
public class _367_Valid_Perfect_Square {

  public boolean isPerfectSquare(int num) {
    if (num == 0) {
      return false;
    }
    int l = 1, r = num;

    while (l <= r) {
      int mid = (l + r) >>> 1;
      long guess = (long) mid * (long) mid;
      if (guess == num) {
        return true;
      } else if (guess < num) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;

  }

  public static void main(String[] args) {
    _367_Valid_Perfect_Square q = new _367_Valid_Perfect_Square();
    System.out.println(q.isPerfectSquare(2147483647));
  }

}
