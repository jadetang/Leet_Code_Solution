package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _986_Interval_List_Intersections {

  public int[][] intervalIntersection(int[][] a, int[][] b) {
    List<int[]> list = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      int[] intervalA = a[i];
      int[] intervalB = b[j];
      if (intervalA[1] < intervalB[0]) {
        i++;
      }else if (intervalA[0] > intervalB[1]){
        j++;
      }else {
        list.add(new int[]{Math.max(intervalA[0], intervalB[0]), Math.min(intervalA[1], intervalB[1])});
        if (intervalA[1] >= intervalB[1]) {
          j++;
        }else {
          i++;
        }
      }
    }
    int[][] ans = new int[list.size()][2];
    for (i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }

}
