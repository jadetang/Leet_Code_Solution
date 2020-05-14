package leetcode;

import java.util.LinkedList;
import java.util.Stack;
import org.junit.Test;
import util.Assert;

public class _862_Shortest_Subarray_with_Sum_at_Least_K {

    @Test
    public void test() {
        _862_Shortest_Subarray_with_Sum_at_Least_K q = new _862_Shortest_Subarray_with_Sum_at_Least_K();
        int[] array = new int[] {2, -1, 2};
        Assert.assertEqual(3, q.shortestSubarray(array,3 ));
    }

    public int shortestSubarray(int[] a, int k) {
        int[] presum = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            presum[i + 1] = presum[i] + a[i];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < presum.length; i++) {
            while (!stack.isEmpty() && presum[stack.peekLast()] >= presum[i]) {
                stack.pollLast();
            }
            while (!stack.isEmpty() && presum[i] - presum[stack.peekFirst()] >= k) {
                ans = Math.min(ans, i - stack.pollFirst());
            }
            stack.offerLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
