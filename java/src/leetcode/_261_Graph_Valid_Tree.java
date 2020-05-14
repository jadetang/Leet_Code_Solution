package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class _261_Graph_Valid_Tree {

  @Test
  public void test() {
    _261_Graph_Valid_Tree q = new _261_Graph_Valid_Tree();
    int n = 5;
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}};
    int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    Assert.assertFalse(q.validTree(n, edges));
    Assert.assertFalse(q.validTree2(n, edges));
    Assert.assertTrue(q.validTree(n, edges2));
    Assert.assertTrue(q.validTree2(n, edges2));
  }

  public boolean validTree2(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      if (dsu.isConnected(edge[0], edge[1])) {
        return false;
      }else {
        dsu.connect(edge[0], edge[1]);
      }
    }
    return dsu.count == 1;
  }

  public static class DSU {

    int[] array;
    int count;
    public DSU(int n) {
      array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = i;
      }
      count = n;
    }

    public boolean isConnected(int i, int j) {
      return find(i) == find(j);
    }

    public void connect(int i, int j) {
      int rooti = find(i);
      int rootj = find(j);
      if (rooti != rootj) {
        count--;
      }
      array[rootj] = rooti;
    }

    public int find(int n) {
      while ( n != array[n]) {
        n = array[n];
      }
      return n;
    }

  }

  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Integer> path = new HashMap<>();
    if (edges.length > 0) {
      queue.offer(edges[0][0]);
    }
    visited.add(0);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Integer v = queue.poll();
        for (Integer nextV : graph.get(v)) {
          if (visited.contains(nextV)) {
            if (path.get(v) != null && !path.get(v).equals(nextV)) {
              return false;
            }
          } else {
            visited.add(nextV);
            path.put(nextV, v);
            queue.offer(nextV);
          }
        }
      }
    }
    return visited.size() == n;
  }

}
