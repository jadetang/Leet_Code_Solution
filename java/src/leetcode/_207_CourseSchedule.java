package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 16/8/19 上午9:28
 */
public class _207_CourseSchedule {


  private boolean[] marked;
  private boolean[] onStack;
  private boolean canFinish = true;

  public static void main(String[] args) {
    _207_CourseSchedule q = new _207_CourseSchedule();
    int[][] course = new int[][]{{0, 1}, {1, 0}};
    // int[][] course = new int[][] {{0,1}};
    System.out.println(q.canFinish(2, course));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 1) {
      return true;
    } else {
      Digraph digraph = new Digraph(numCourses);
      for (int[] prerequisite : prerequisites) {
        digraph.addEdge(prerequisite[0], prerequisite[1]);
      }
      marked = new boolean[numCourses];
      onStack = new boolean[numCourses];
      for (int v = 0; v < digraph.v(); v++) {
        if (!marked[v]) {
          dfs(digraph, v);
        }
      }
      return canFinish;
    }
  }

  private void dfs(Digraph digraph, int v) {
    onStack[v] = true;
    marked[v] = true;
    for (Integer adj : digraph.adj(v)) {
      if (onStack[adj]) {
        canFinish = false;
        return;
      } else {
        if (!marked[adj]) {
          dfs(digraph, adj);
        }
      }
    }
    onStack[v] = false;
  }

  public static class Digraph {

    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int vertexNum) {
      adj = (List<Integer>[]) new List[vertexNum];
      for (int i = 0; i < adj.length; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    public void addEdge(int v, int w) {
      if (!adj[v].contains(w)) {
        adj[v].add(w);
      }
    }

    public Integer v() {
      return adj.length;
    }

    public List<Integer> adj(Integer vertex) {
      return adj[vertex];
    }
  }

}
