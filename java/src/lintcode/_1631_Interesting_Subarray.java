
package lintcode;

import java.util.HashMap;
import java.util.Map;

public class _1631_Interesting_Subarray {


  public static void main(String[] args) {
    _1631_Interesting_Subarray q = new _1631_Interesting_Subarray();
    int[] data = new int[]{3, 2, 3, 1, 5, 2, 5, 1};
    System.out.println(q.maxLen(data));
  }


  public int maxLen(int[] a) {

    if (a == null || a.length == 0) {
      return 0;
    }
    if (a.length == 1 || a.length == 2) {
      return a.length;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int l = 0;
    int r = 0;
    inMap(map, a[r]);
    while (r < a.length) {
      while (r < a.length && isInteresting(map)) {
        //  System.out.println("valid map"+map);
        //  System.out.println(l+":"+r);
        max = Math.max(max, r - l + 1);
        r++;
        if (r < a.length) {
          inMap(map, a[r]);
        }

      }
      while (l <= r && !isInteresting(map)) {

        outMap(map, a[l++]);
        // System.out.println("out map"+map);
      }
    }
    return max;
  }

  private void inMap(Map<Integer, Integer> map, int val) {
    map.put(val, map.getOrDefault(val, 0) + 1);
  }

  private boolean isInteresting(Map<Integer, Integer> map) {
    return map.size() <= 2;
  }

  private void outMap(Map<Integer, Integer> map, int val) {
    map.put(val, map.get(val) - 1);
    if (map.get(val) == 0) {
      map.remove(val);
    }
  }
}

