package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _815_Bus_Routes {

    @Test
    public void test() {
        _815_Bus_Routes q = new _815_Bus_Routes();
        int[][] routes = new int[][]{{1, 2, 7}, {3, 6, 7}};
        Assert.assertEqual(2, q.numBusesToDestination(routes, 1, 6));
    }

    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (s == t) {
            return 0;
        }
        Map<Integer, Set<Integer>> busToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                busToRoutes.computeIfAbsent(stop, k -> new HashSet<>()).add(i);
            }
        }
        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer route : busToRoutes.get(s)) {
            queue.offer(route);
            visitedRoutes.add(route);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentRoute = queue.poll();
                for (Integer busStop : routes[currentRoute]) {
                    if (busStop == t) {
                        return count;
                    }
                    for (Integer route : busToRoutes.get(busStop)) {
                        if (!visitedRoutes.contains(route)) {
                            visitedRoutes.add(currentRoute);
                            queue.offer(route);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
