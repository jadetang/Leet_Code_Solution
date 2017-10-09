package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 16/8/23 上午9:06
 */
public class _210_CourseScheduleII {


  private LinkedList<Integer> queue = new LinkedList<>();
  private boolean[] marked;
  private boolean[] onStack;
  private boolean hasCircle;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) {
      return new int[]{};
    } else if (numCourses == 1) {
      return new int[]{0};
    } else {
      Digraph digraph = new Digraph(numCourses);
      marked = new boolean[numCourses];
      onStack = new boolean[numCourses];
      for (int[] prerequisite : prerequisites) {
        digraph.addEdge(prerequisite[0], prerequisite[1]);
      }
      for (int v = 0; v < digraph.v(); v++) {
        if (!marked[v]) {
          dfs(digraph, v);
        }
      }
      if (hasCircle) {
        return null;
      } else {
        int[] result = new int[queue.size()];
        int index = 0;
        for (Integer i :
            queue) {
          result[index++] = i;
        }
        return result;
      }
    }
  }

  private void dfs(Digraph digraph, int v) {

    marked[v] = true;
    onStack[v] = true;
    for (Integer adj : digraph.adj(v)) {
      if (onStack[adj]) {
        hasCircle = true;
        return;
      }
      if (!marked[adj]) {
        dfs(digraph, adj);
      }
    }
    queue.offer(v);
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

  public static void main(String[] args) {
    _210_CourseScheduleII q = new _210_CourseScheduleII();
    int[][] course = new int[][]{{0, 1}, {1, 0}};
    // int[][] course = new int[][] {{0,1}};
    System.out.println(q.findOrder(2, course));
  }
}
