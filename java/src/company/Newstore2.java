package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Newstore2 {

  public static String ShortestPath(String[] strArr) {

    Graph graph = buildGraph(strArr);
    String startPoint = strArr[1];
    String destination = strArr[graph.vertexNumber()];
    Set<String> visited = new HashSet<>();
    visited.add(startPoint);
    Queue<String> queue = new LinkedList<>();
    Map<String, String> routes = new HashMap<>();
    queue.offer(startPoint);

    while (!queue.isEmpty()) {
      String currentVertex = queue.poll();
      for (String neighbour : graph.neighbours(currentVertex)) {
        if (!visited.contains(neighbour)) {
          routes.put(neighbour, currentVertex);
          visited.add(neighbour);
          queue.offer(neighbour);
        }
      }
    }
    if (!routes.containsKey(destination)) {
      return "-1";
    }
    return buildPath(routes, destination);
    // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */

  }

  private static String buildPath(Map<String, String> routes, String destination) {
    List<String> paths = new ArrayList<>();
    String currentVertex = destination;
    while (currentVertex != null) {
      paths.add(currentVertex);
      currentVertex = routes.get(currentVertex);
    }
    Collections.reverse(paths);
    return paths.stream().collect(Collectors.joining("->"));
  }

  private static Graph buildGraph(String[] strArr) {
    int vertexNumber = Integer.valueOf(strArr[0]);
    Graph graph = new Graph();
    for (int i = 1; i <= vertexNumber; i++) {
      graph.addVertex(strArr[i]);
    }
    for (int i = vertexNumber + 1; i < strArr.length; i++) {
      String[] vertexs = strArr[i].split("-");
      graph.connect(vertexs[0], vertexs[1]);
    }
    return graph;
  }

  public static void main(String[] args) {
    System.out.println(ShortestPath(
        new String[]{"5", "A", "B", "C", "D", "F", "A-B", "A-C", "B-C", "C-D", "D-F"}));
    System.out.println(ShortestPath(new String[]{"4", "X", "Y", "Z", "W", "X-Y", "Y-Z", "X-W"}));
    System.out.println(ShortestPath(new String[]{"1", "X"}));
    System.out.println(ShortestPath(new String[]{"2", "X", "Y"}));
    System.out.println(ShortestPath(
        new String[]{"5", "N1", "N2", "N3", "N4", "N5", "N1-N3", "N3-N4", "N4-N5", "N5-N2",
            "N2-N1"}));
  }

  public static class Graph {

    private Map<String, List<String>> graph = new HashMap<>();

    public int vertexNumber() {
      return graph.size();
    }

    public void addVertex(String vertex) {
      graph.put(vertex, new ArrayList<>());
    }

    public void connect(String vertex1, String vertex2) {
      graph.get(vertex1).add(vertex2);
      graph.get(vertex2).add(vertex1);
    }

    public List<String> neighbours(String vertex) {
      return graph.get(vertex);
    }

  }

}
