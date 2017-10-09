package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 用堆来排序
 *
 * @author sanguan.tangsicheng on 2017/7/6 下午8:00
 */
public class _295_Find_Median_from_Data_Stream {

  PriorityQueue<Integer> low = new PriorityQueue<>();

  PriorityQueue<Integer> high = new PriorityQueue<>(Comparator.reverseOrder());

  /**
   * initialize your data structure here.
   */
  public _295_Find_Median_from_Data_Stream() {

  }

  public void addNum(int num) {
    low.add(num);
    high.add(low.poll());
    if (low.size() < high.size()) {
      low.add(high.poll());
    }
  }


  public double findMedian() {
    if (low.size() == 0 && high.size() == 0) {
      return 0.0;
    } else {
      if (low.size() == high.size()) {
        return (low.peek() + high.peek()) / 2.0;
      } else {
        return low.peek();
      }
    }
  }


  public static void main(String[] args) {

  }

}
