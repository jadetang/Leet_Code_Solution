package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jade on 2017/7/30 下午3:24
 */
public class _633_Sum_of_Square_Numbers {

  public static boolean judgeSquareSum(int c) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i * i <= c; i++) {
      int temp = i * i;
      if (set.contains(c - temp)) {
        return true;
      } else if (temp + temp == c) {
        return true;
      }
      set.add(temp);
    }
    return false;
  }


  public static void main(String[] args) {
    System.out.println(judgeSquareSum(4));
    System.out.println(judgeSquareSum(2));
    System.out.println(judgeSquareSum(5));
    System.out.println(judgeSquareSum(2147482647));
  }


}
