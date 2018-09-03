package solution;

import level.Easy;

/**
 * @author jade on 2016/11/24 下午10:05
 */
public class _441_Arranging_Coins implements Easy {

  public int arrangeCoins(int n) {
    int l = 1;
    int r = n;
    //int m = (n-l) << 2;
    while (l <= r) {
      int mid = (l + r) >>> 1;
      long count = count(mid);
      if (count == n || (count < n && count(mid + 1) > n)) {
        return mid;
      } else if (count < n) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }

    }
    return l;
  }

  private long count(long n) {
    return n * (n + 1) / 2;
  }

  public static void main(String[] args) {
    _441_Arranging_Coins q = new _441_Arranging_Coins();
    System.out.println(q.arrangeCoins(1804289383));
  }
}
