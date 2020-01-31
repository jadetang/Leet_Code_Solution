package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jade on 2016/11/13 上午10:01
 */
public class _447_Number_of_Boomerangs {

  public int numberOfBoomerangs(int[][] points) {
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Integer, Integer> hash = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        } else {
          int dist = getDistance(points[i], points[j]);
          hash.put(dist, hash.getOrDefault(dist, 0) + 1);
        }
      }
      for (Integer val : hash.values()) {
        result += val * (val - 1);
      }
    }
    return result;
  }

  int getDistance(int[] p1, int[] p2) {
    int x = p1[0] - p2[0];
    int y = p1[1] - p2[1];
    return x * x + y * y;
  }

}
