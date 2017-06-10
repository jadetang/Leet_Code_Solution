package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sanguan.tangsicheng on 2017/6/10 下午3:53
 */
public class _84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (; i < len; ) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
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
        int[] height = new int[] {2, 5, 3, 4, 1};
        System.out.println(q.largestRectangleArea(height));
    }

}
