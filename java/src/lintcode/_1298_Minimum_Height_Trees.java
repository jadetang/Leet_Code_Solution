package lintcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class _1298_Minimum_Height_Trees {


  /**
   * @param n: n nodes labeled from 0 to n - 1
   * @param edges: a undirected graph
   * @return: a list of all the MHTs root labels
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    if (edges == null || edges.length == 0) {
      return Collections.emptyList();
    }

    if (edges.length <= 2) {
      List<Integer> list = new ArrayList<>();
      for (int[] edge : edges) {
        list.add(edge[0]);
      }
      return list;
    }

    Graph g = new Graph(edges);
    while (g.v().size() > 2) {
      for (Integer leaf : g.leaves()) {
        g.removeLeaf(leaf);
      }
    }
    return new ArrayList<>(g.v());

    // Wirte your code here
  }

  public static class Graph {

    Map<Integer, Set<Integer>> data = new HashMap<>();

    public Graph(int[][] edges) {
      for (int[] edge : edges) {
        addEdge(edge[0], edge[1]);
        addEdge(edge[1], edge[0]);
      }
    }


    private void addEdge(int from, int to) {
      if (!data.containsKey(from)) {
        data.put(from, new HashSet<>());
      }
      data.get(from).add(to);
    }


    public Collection<Integer> v() {
      return data.keySet();
    }

    public List<Integer> leaves() {
      return data.entrySet().stream().filter(e -> e.getValue().size() == 1).map(Entry::getKey).
          collect(Collectors.toList());
    }

    public void removeLeaf(int v) {
      int to = data.get(v).stream().findAny().get();
      data.get(to).remove(v);
      data.remove(v);
    }


  }

}
