package leetcode;

public class _785_Is_Graph_Bipartite {


  boolean bipartite = true;

  boolean[] visited;

  boolean[] color;

  int[][] graph;

  public boolean isBipartite(int[][] graph) {
    this.visited = new boolean[graph.length];
    this.color = new boolean[graph.length];
    this.graph = graph;
    for (int[] edges : graph) {
      if (edges.length > 1) {
        dfs(edges[0]);
      }
    }
    return bipartite;
  }

  private void dfs(int vertex) {
    for (int v : graph[vertex]) {
      if (!visited[v]) {
        visited[v] = true;
        color[v] = !color[vertex];
        dfs(v);
      } else if (color[v] == color[vertex]) {
        bipartite = false;
        return;
      }
    }
  }

}
