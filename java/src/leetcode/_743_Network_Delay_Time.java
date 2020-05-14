package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import org.junit.Test;
import util.Assert;

public class _743_Network_Delay_Time {

    @Test
    public void test() {
        _743_Network_Delay_Time q = new _743_Network_Delay_Time();
        int[][] times = new int[][] {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        Assert.assertEqual(2, q.networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], s -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> distance[i[0]]));
        queue.offer(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            for (int[] adj : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = adj[0];
                int distanceToNextNode = adj[1];
                if (distance[nextNode] > distanceToNextNode + distance[currentNode]) {
                    distance[nextNode] = distanceToNextNode + distance[currentNode];
                    queue.remove(adj);
                    queue.offer(adj);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(distance[i], max);
        }
        return max;
    }
}
