package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class _1192_Critical_Connections_in_a_Network {

    @Test
    public void test() {
        _1192_Critical_Connections_in_a_Network q = new _1192_Critical_Connections_in_a_Network();
        int n = 6;
        List<List<Integer>> connections = List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3), List.of(3, 4), List.of(4, 5), List.of(5, 3));
        System.out.println(q.criticalConnections(n, connections));
    }

    List<List<Integer>> ans = new ArrayList<>();

    int count = 0;

    boolean[] visited;

    int[] id;

    int[] low;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        visited = new boolean[n];
        id = new int[n];
        low = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int k = 0; k < connections.size(); k++) {
            List<Integer> connection = connections.get(k);
            int i = connection.get(0);
            int j = connection.get(1);
            graph.computeIfAbsent(i, key -> new ArrayList<>()).add(j);
            graph.computeIfAbsent(j, key -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph);
            }
        }
        return ans;
    }

    private void dfs(int at, int parent, Map<Integer, List<Integer>> graph) {
        System.out.println("visit " + at + " parent " + parent);
        visited[at] = true;
        count++;
        low[at] = id[at] = count;

        for (int to : graph.get(at)) {
            if (!visited[to]) {
                dfs(to, at, graph);
                if (id[at] < low[to]) {
                    ans.add(List.of(at, to));
                }
                low[at] = Math.min(low[at], low[to]);
            }else{
                if( to != parent) {
                    low[at] = Math.min(low[at], id[to]);
                }
            }
        }
    }

}
