package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You
 * receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this
 * new language. Derive the order of letters in this language.
 * <p>
 * Example 1:
 * <p>
 * Input: [ "wrt", "wrf", "er", "ett", "rftt" ]
 * <p>
 * Output: "wertf" Example 2:
 * <p>
 * Input: [ "z", "x" ]
 * <p>
 * Output: "zx" Example 3:
 * <p>
 * Input: [ "z", "x", "z" ]
 * <p>
 * Output: ""
 * <p>
 * Explanation: The order is invalid, so return "". Note:
 * <p>
 * You may assume all letters are in lowercase. You may assume that if a is a prefix of b, then a must appear before b
 * in the given dictionary. If the order is invalid, return an empty string. There may be multiple valid order of
 * letters, return any one of them is fine.
 */

public class _269_Alien_Dictionary {

    @Test
    public void test() {
        String[] words = new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        _269_Alien_Dictionary q = new _269_Alien_Dictionary();
        Assert.assertEquals("wertf", q.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String next = words[i + 1];
            for (int j = 0; j < Math.min(pre.length(), next.length()); j++) {
                if (pre.charAt(j) != next.charAt(j)) {
                    graph.computeIfAbsent(pre.charAt(j), key -> new ArrayList<>()).add(next.charAt(j));
                    inDegree.put(next.charAt(j), inDegree.getOrDefault(next.charAt(j), 0) + 1);
                    inDegree.putIfAbsent(pre.charAt(j), 0);
                    break;
                }
            }
        }
        Queue<Character> source = new LinkedList<>(
                inDegree.entrySet().stream().filter(e -> e.getValue() == 0).map(Entry::getKey).collect(
                        Collectors.toList()));
        StringBuilder sb = new StringBuilder();
        while (!source.isEmpty()) {
            int size = source.size();
            for (int i = 0; i < size; i++) {
                char c = source.poll();
                sb.append(c);
                List<Character> neigbors = graph.get(c);
                if (neigbors != null) {
                    for (Character n : neigbors) {
                        inDegree.put(n, inDegree.get(n) - 1);
                        if (inDegree.get(n) == 0) {
                            source.offer(n);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}

