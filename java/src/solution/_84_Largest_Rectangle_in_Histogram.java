package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jade on 2017/6/10 下午3:53
 */
public class _84_Largest_Rectangle_in_Histogram {

  public int largestRectangleArea2(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    return largestArea(heights, 0, heights.length - 1);
  }

  private int largestArea(int[] heights, int l, int r) {
    if (l == r) {
      return heights[l];
    } else {
      int mid = l + (r - l) / 2;
      return max(largestArea(heights, l, mid), largestArea(heights, mid + 1, r),
          largestCombine(heights, mid, l, r));

    }
  }

  private int largestCombine(int[] heights, int mid, int l, int r) {
    int area = Integer.MIN_VALUE;
    int left = mid;
    int right = mid + 1;
    int h = Math.min(heights[left], heights[right]);
    ;
    System.out.println(String.format("mid:%d,l:%d,r:%d", mid, l, r));
    while (left >= l && right <= r) {
      h = Math.min(h, Math.min(heights[left], heights[right]));

      int temp = (right - left + 1) * h;

      System.out.println(String.format("area:%d,left:%d,right:%d", temp, left, right));

      area = Math.max(temp, area);
      if (left == l) {
        right++;
      } else if (right == r) {
        left--;
      } else {

        // if both sides have not reached the boundary,
        // compare the outer bars and expand towards the bigger side
        if (heights[left - 1] > heights[right + 1]) {
          left--;
        } else {
          right++;
        }
      }

    }
    return area;
  }

  private int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  public int largestRectangleArea(int[] height) {
    int len = height.length;
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int i = 0;
    for (; i < len; ) {
      if (stack.isEmpty() || height[i] >= height[stack.peek()
          ]) {
        stack.push(i);
        i++;
      } else {
        int tp = stack.pop();
        max = Math.max(max, height[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
      }
    }
    while (!stack.isEmpty()) {
      int tp = stack.pop();
      max = Math.max(max, height[tp] * (stack.isEmpty() ? len : len - stack.peek() - 1));
    }
    return max;
  }

  public static void main(String[] args) {
    _84_Largest_Rectangle_in_Histogram q = new _84_Largest_Rectangle_in_Histogram();
    int[] height = new int[]{2, 1, 5, 6, 2, 3};
    System.out.println(q.largestRectangleArea(height));
    System.out.println(q.largestRectangleArea2(height));
  }

}
