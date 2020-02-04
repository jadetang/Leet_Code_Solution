package leetcode;

import java.util.HashMap;
import ds.Point;

/**
 * @author jade on 2017/7/2 下午7:06
 */
public class _149_Max_Points_on_a_Line {


  public int maxPoints(Point[] points) {
    if (points.length <= 0) {
      return 0;
    }
    if (points.length <= 2) {
      return points.length;
    }
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
      int samex = 1;
      int samep = 0;
      for (int j = 0; j < points.length; j++) {
        if (j != i) {
          if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
            samep++;   //同一个点
          }
          if (points[j].x == points[i].x) {
            samex++;     //在一条竖线上
            continue;
          }
          double k =
              (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);  //斜率
          if (hm.containsKey(k)) {
            hm.put(k, hm.get(k) + 1);
          } else {
            hm.put(k, 2);
          }
          result = Math.max(result, hm.get(k) + samep);
        }
      }
      result = Math.max(result, samex);
    }
    return result;
  }
}
