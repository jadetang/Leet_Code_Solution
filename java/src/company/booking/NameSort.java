package company.booking;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.careercup.com/question?id=5378451464781824
 *
 * @author sanguan.tangsicheng on 2017/7/1 上午10:17
 */
public class NameSort {

  private static String[] names = {"luis", "hector", "selena", "emmanuel", "amish", "anna",
      "andrea", "rawle", "x"};
  // private static String[] names = {"luis", "hector", "selena", "emmanuex", "amish", "anna", "andrea", "rawle"};

  public static void main(String[] args) {

    Graph graph = construct(names);
    char x = findStart(graph);
    System.out.println(eulerPath(graph, x));
  }

  private static List<String> eulerPath(Graph graph, char current) {
    List<String> result = new LinkedList<>();
    while (isNotEnd(graph, current)) {
      Edge next = null;
      for (Edge e : graph.edges(current)) {
        if (!e.visited && e.start == e.end) {
          next = e;
          break;
        }
      }
      if (next == null) {
        for (Edge e : graph.edges(current)) {
          if (!e.visited) {
            next = e;
            break;
          }
        }
      }
      next.visited = true;
      result.add(next.edge);
      current = next.end;
    }
    return result;
  }

  private static boolean isNotEnd(Graph graph, char c) {
    for (Edge e :
        graph.edges(c)) {
      if (!e.visited) {
        return true;
      }
    }
    return false;
  }

  private static char findStart(Graph graph) {
    for (char x : graph.vertex()) {
      if (graph.outDegree(x) - graph.inDegree(x) == 1) {
        return x;
      }
    }
    return graph.vertex().stream().findFirst().get();

  }

  private static void traverse(List<String> result, Map<Character, LinkedList<Edge>> graph) {

  }

  private static Graph construct(String[] names) {
    Graph g = new Graph();
    for (String name : names) {
      g.addEdge(new Edge(name));
    }
    return g;
  }

  public static class Graph {

    Map<Character, LinkedList<Edge>> data = new HashMap<>();

    Map<Character, Integer> inDegree = new HashMap<>();

    Map<Character, Integer> outDegree = new HashMap<>();

    public void addEdge(Edge e) {

      if (!data.containsKey(e.start)) {
        data.put(e.start, new LinkedList<>());
      }
      if (!data.containsKey(e.end)) {
        data.put(e.end, new LinkedList<>());
      }
      data.get(e.start).add(e);
      outDegree.put(e.start, outDegree.getOrDefault(e.start, 0) + 1);
      inDegree.put(e.end, inDegree.getOrDefault(e.end, 0) + 1);

    }

    public Collection<Character> vertex() {
      return data.keySet();
    }

    public Collection<Edge> edges(char x) {
      return data.get(x);
    }

    public int inDegree(char x) {
      return inDegree.getOrDefault(x, 0);
    }

    public int outDegree(char x) {
      return outDegree.getOrDefault(x, 0);
    }

  }

  public static class Edge {

    char start;
    char end;
    String edge;

    boolean visited = false;

    public Edge(String s) {
      this.start = s.charAt(0);
      this.end = s.charAt(s.length() - 1);
      this.edge = s;
    }

    @Override
    public String toString() {
      return this.edge;
    }
  }

}
