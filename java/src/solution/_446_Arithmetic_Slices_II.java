package solution;

import level.Medium;
import tag.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jade on 2016/11/23 下午9:28 https://discuss.leetcode.com/topic/67413/detailed-explanation-for-java-o-n-2-solution
 */
public class _446_Arithmetic_Slices_II implements Medium, DynamicProgramming {

  public int numberOfArithmeticSlices(int[] A) {
    int res = 0;
    Map<Integer, Integer>[] map = new Map[A.length];
    for (int i = 0; i < A.length; i++) {
      map[i] = new HashMap<>();
      for (int j = 0; j < i; j++) {
        long diff = (long) A[i] - A[j];
        if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
          continue;
        } else {
          int d = (int) diff;
          int c1 = map[i].getOrDefault(d, 0);
          int c2 = map[j].getOrDefault(d, 0);
          res += c2;
          map[i].put(d, c1 + c2 + 1);
        }
      }
    }
    return res;
  }


}
