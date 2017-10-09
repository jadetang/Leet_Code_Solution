package solution;

import level.Medium;

/**
 * @author sanguan.tangsicheng on 2016/12/3 上午9:25
 */
public class _365_Water_and_Jug_Problem implements Medium {

  public boolean canMeasureWater(int x, int y, int z) {
    if (x > y) {
      int temp = x;
      x = y;
      y = temp;
    }
    int gcd = gcd(x, y);
    if (gcd == 0) {
      return z == 0;
    }
    return z % gcd(x, y) == 0 && z <= x + y;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  public static void main(String[] args) {
    _365_Water_and_Jug_Problem q = new _365_Water_and_Jug_Problem();
    System.out.println(q.canMeasureWater(3, 5, 4));
  }
}
