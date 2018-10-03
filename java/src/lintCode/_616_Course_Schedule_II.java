package lintCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import util.Util;

public class _616_Course_Schedule_II {

  public static void main(String[] args) {
    _616_Course_Schedule_II q = new _616_Course_Schedule_II();
    int[] a = q.findOrder(2, new int[][]{{1, 0}});
    Util.print(a);
  }


  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // write your code here
    Graph g = new Graph(numCourses);
    for (int[] prerequisite : prerequisites) {
      g.addEdge(prerequisite[1], prerequisite[0]);
    }
    TopologicalSort t = new TopologicalSort(g);
    if (t.hasCircle) {
      return new int[]{};
    }
    return t.reverseOrder();
  }

  public static class TopologicalSort {

    private Graph g;

    private boolean[] visited;

    private boolean[] onStack;

    private Deque<Integer> list;

    private boolean hasCircle;

    public TopologicalSort(Graph g) {
      this.g = g;
      this.visited = new boolean[g.nodes()];
      this.onStack = new boolean[g.nodes()];
      this.list = new LinkedList<>();
      for (int i = 0; i < g.nodes(); i++) {
        if (!visited[i]) {
          dfs(i);
        }
      }
    }


    private void dfs(int i) {
      this.onStack[i] = true;
      this.visited[i] = true;
      for (int j : g.adj(i)) {
        if (hasCircle) {
          return;
        }
        if (!visited[j]) {
          dfs(j);
        } else if (onStack[j]) {
          hasCircle = true;
          return;
        }

      }
      list.offerLast(i);
      this.onStack[i] = false;
    }


    public int[] reverseOrder() {
      return this.list.stream().mapToInt(i -> i).toArray();
    }
  }

  public static class Graph {

    Map<Integer, List<Integer>> g = new HashMap<>();

    public Graph(int v) {
      for (int i = 0; i < v; i++) {
        g.put(i, new ArrayList<>());
      }
    }


    public void addEdge(int from, int to) {
      g.get(from).add(to);
    }

    public List<Integer> adj(int from) {
      return g.get(from);
    }

    public int nodes() {
      return g.size();
    }

  }

}
