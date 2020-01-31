package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EditToTarget {

  static char[] chars = new char[] {'a','b','c','d','e','f','g','h','i','j','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

  static Map<String, Set<String>> graph;

  static int shortestWordEditPath(String source, String target, String[] words) {
    graph = buildGraph(source, words);
    int dist = 0;
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(source);
    visited.add(source);
    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String current = queue.poll();
        if (current.equals(target)) {
          return dist;
        }
        for (String next : graph.get(current)) {
          if (!visited.contains(next)) {
            visited.add(next);
            queue.offer(next);
          }
        }
      }
      dist++;
    }
    return -1;
    // your code goes here
  }

  static Map<String, Set<String>> buildGraph(String source, String[] words) {
    Map<String, Set<String>> graph = new HashMap<>();
    Set<String> dict = new HashSet<>(Arrays.asList(words));
    dict.add(source);
    for (String word : dict) {
      graph.putIfAbsent(word, new HashSet<>());
      for (int i = 0; i < word.length(); i++) {
        for (int j = 0; j < chars.length; j++) {
          String nextWord = null;
          if (i == word.length() -1) {
            nextWord = word.substring(0, i) + chars[j];
          }else {
            nextWord = word.substring(0, i) + chars[j] + word.substring(i+1);
          }
          if (!word.equals(nextWord) && dict.contains(nextWord)) {
            graph.get(word).add(nextWord);
          }
        }
      }
    }
    return graph;
  }


  public static void main(String[] args) {
    String source = "bit";
    String target = "but";
    String[] words = new String[] {"but", "put", "big", "pot", "pog", "dog", "lot"};
    System.out.println(shortestWordEditPath (source, target, words));
  }
}
