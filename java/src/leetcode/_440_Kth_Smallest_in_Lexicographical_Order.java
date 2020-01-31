package leetcode;

import java.util.PriorityQueue;
import level.Hard;

/**
 * @author jade on 2016/11/24 下午10:34
 */
public class _440_Kth_Smallest_in_Lexicographical_Order implements Hard {

  public static void main(String[] args) {
    _440_Kth_Smallest_in_Lexicographical_Order q = new _440_Kth_Smallest_in_Lexicographical_Order();
    for (int i = 0; i < 100; i++) {
      long start = System.currentTimeMillis();

      System.out.println(q.findKthNumberHeap(4389384, 1922239));
      System.out.println("cost:" + (System.currentTimeMillis() - start));
      start = System.currentTimeMillis();
      System.out.println(q.findKthNumber(4389384, 1922239));
      System.out.println("cost:" + (System.currentTimeMillis() - start));
    }
  }

  //quick select  Memory List Exceed
  public int findKthNumber(int n, int k) {
    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
      str[i] = String.valueOf(i + 1);
    }
    return findKth(str, 0, str.length - 1, k - 1);


  }

  private int findKth(String[] str, int start, int end, int k) {
    int low = start;
    int high = end;
    String pivot = str[start];
    while (true) {
      while (str[low].compareTo(pivot) <= 0 && low < end) {
        low++;
      }
      while (str[high].compareTo(pivot) > 0 && high > start) {
        high--;
      }
      if (low >= high) {
        break;
      }
      swap(str, low, high);
    }
    swap(str, start, high);
    if (high == k) {
      return Integer.valueOf(str[high]);
    } else if (high > k) {
      return findKth(str, start, high - 1, k);
    } else {
      return findKth(str, high + 1, end, k);
    }
  }

  private void swap(String[] str, int i, int j) {
    String temp = str[i];
    str[i] = str[j];
    str[j] = temp;
  }

  //Time Limit Exceed
  public int findKthNumberHeap(int n, int k) {
    PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
      return o2.compareTo(o1);
    });
    for (int i = 1; i <= n; i++) {
      if (queue.size() < k) {
        queue.add(String.valueOf(i));
      } else {
        String maxString = queue.peek();
        if (String.valueOf(i).compareTo(maxString) < 0) {
          queue.poll();
          queue.add(String.valueOf(i));
        }
      }
    }
    return Integer.parseInt(queue.poll());
  }


}
