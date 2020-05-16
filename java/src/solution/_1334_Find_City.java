package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1334_Find_City {

    public static void main(String[] args) {
        _1334_Find_City q = new _1334_Find_City();
        int[][] edges = new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(q.findTheCity(5, edges, 2));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Graph graph = new Graph(n);
        for (int[] edge : edges) {
            graph.connect(edge[0], edge[1], edge[2]);
        }
        int reachCity = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            Dijkstra dijkstra = new Dijkstra(graph, i);
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (dijkstra.distance[j] <= distanceThreshold) {
                    reachable++;
                }
            }
            reachable--;
            if (reachable < reachCity) {
                reachCity = reachable;
                ans = i;
            } else if (reachable == reachCity) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    public static class Edge {

        int from;
        int to;
        int value;

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static class Graph {

        List<Edge>[] edges;

        int n;

        public Graph(int n) {
            this.n = n;
            this.edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        public void connect(int from, int to, int value) {
            edges[from].add(new Edge(from, to, value));
            edges[to].add(new Edge(to, from, value));
        }

        public List<Edge> edges(int v) {
            return edges[v];
        }
    }

    public static class Dijkstra {

        int[] distance;

   //     boolean[] visited;

        PriorityQueue<Integer> queue;

        public Dijkstra(Graph g, int from) {
            distance = new int[g.n];
         //   visited = new boolean[g.n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[from] = 0;
            queue = new PriorityQueue<>(Comparator.comparingInt(i -> distance[i]));
            queue.offer(from);
      //      visited[from] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (Edge e : g.edges(current)) {
                    int w = e.to;
                    if (distance[w] > distance[current] + e.value) {
                        distance[w] = distance[current] + e.value;
                        queue.remove(w);
                        queue.offer(w);
                    }
                }
            }
        }

        public int dist(int to) {
            return distance[to];
        }
    }

}
