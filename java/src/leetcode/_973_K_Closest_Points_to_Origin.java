package leetcode;

import java.util.PriorityQueue;

public class _973_K_Closest_Points_to_Origin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] p : points) {
            queue.offer(p);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] ans = new int[queue.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
