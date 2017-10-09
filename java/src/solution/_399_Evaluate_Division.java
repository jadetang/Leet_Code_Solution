package solution;


import java.util.*;

public class _399_Evaluate_Division {

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    Graph g = new Graph();
    for (int i = 0; i < values.length; i++) {
      String from = equations[i][0];
      String to = equations[i][1];
      Double value = values[i];
      Edge edge = new Edge(from, to, value);
      g.addEdge(edge);
      if (value != 0.0) {
        Edge edge1 = new Edge(to, from, 1 / value);
        g.addEdge(edge1);
      }
    }
    double[] result = new double[queries.length];
    for (int i = 0; i < queries.length; i++) {
      if (!g.contains(queries[i][0]) || !g.contains(queries[i][1])) {
        result[i] = -1.0;
      } else if (queries[i][0].equals(queries[i][1])) {
        result[i] = 1.0;
      } else {
        Dfs dfs = new Dfs(g, queries[i][0]);
        List<Edge> edges = dfs.path(queries[i][1]);
        if (edges.isEmpty()) {
          result[i] = -1.0;
        } else {
          double value = edges.stream().map(edge -> edge.value)
              .reduce((aDouble, aDouble2) -> aDouble * aDouble2).get();
          result[i] = value;
        }
      }
    }
    return result;
  }

  public static class Dfs {

    String source;
    Graph g;
    Set<String> marked;
    Map<String, Edge> edgeTo;

    public Dfs(Graph g, String source) {
      this.g = g;
      this.source = source;
      marked = new HashSet<>();
      edgeTo = new HashMap<>();
      dfs(g, this.source);
    }

    private void dfs(Graph g, String vertex) {
      marked.add(vertex);
      for (Edge e : g.edges(vertex)) {
        if (!marked.contains(e.to)) {
          edgeTo.put(e.to, e);
          dfs(g, e.to);
        }
      }
    }

    public boolean reachAble(String desc) {
      return marked.contains(desc);
    }


    public List<Edge> path(String dest) {
      if (!reachAble(dest)) {
        return Collections.emptyList();
      } else {
        String vertex = dest;
        LinkedList<Edge> list = new LinkedList<>();
        while (!vertex.equals(this.source)) {
          Edge edge = edgeTo.get(vertex);
          list.offerLast(edge);
          vertex = edge.from;
        }
        return list;
      }
    }
  }

  public static class Edge {

    public String from;
    public String to;
    public Double value;

    public Edge(String from, String to, Double value) {
      this.from = from;
      this.to = to;
      this.value = value;
    }

    @Override
    public String toString() {
      return "[" + from + ":" + to + "]";
    }
  }


  public static class Graph {

    Map<String, List<Edge>> g;


    public Graph() {
      g = new HashMap<>();
    }

    public void addEdge(Edge edge) {
      if (g.containsKey(edge.from)) {
        g.get(edge.from).add(edge);
      } else {
        List<Edge> list = new LinkedList<>();
        list.add(edge);
        g.put(edge.from, list);
      }
    }

    public List<Edge> edges(String vertex) {
      return g.getOrDefault(vertex, Collections.emptyList());
    }

    public boolean contains(String vertex) {
      return g.containsKey(vertex);
    }

  }

}
