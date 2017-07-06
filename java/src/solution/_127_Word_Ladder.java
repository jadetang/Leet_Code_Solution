package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import level.Medium;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 *
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * @author sanguan.tangsicheng on 2017/5/5 上午7:18
 */
public class _127_Word_Ladder implements Medium {

    /**
     * Basically I keep two sets of words, one set reached that represents the borders that have been reached with
     * "distance" steps; another set wordDict that has not been reached. In the while loop, for each word in the reached
     * set, I give all variations and check if it matches anything from wordDict, if it has a match, I add that word
     * into toAdd set, which will be my "reached" set in the next loop, and remove the word from wordDict because I
     * already reached it in this step. And at the end of while loop, I check the size of toAdd, which means that if I
     * can't reach any new String from wordDict, I won't be able to reach the endWord, then just return 0. Finally if
     * the endWord is in reached set, I return the current steps "distance".
     *
     * The idea is that reached always contain only the ones we just reached in the last step, and wordDict always
     * contain the ones that haven't been reached. This is pretty much what Dijkstra's algorithm does, or you can see
     * this as some variation of BFS.
     *
     * @param beginWord
     * @param endWord
     * @param wordDict
     * @return
     */

    //bfs 但是代码更短
    public int ladderLength2(String beginWord, String endWord, List<String> wordDict2) {
        //已经便利过的词
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        Set<String> wordDict = new HashSet<>(wordDict2);
        int distance = 1;
        while (!reached.contains(endWord)) {
            //下一轮要遍历的词
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        //即使 word = each 也没有关系，因为 wordDict 中肯定没有这个词（在上一轮中已经遍历过了）
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) { return 0; }
            reached = toAdd;
        }
        return distance;
    }

    //本质上一个图，求最短的距离，用 BFS 来做，也可用用 two way bfs 来做
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Graph g = new Graph(wordList);

        Map<String, Boolean> marked = new HashMap<>();

        Map<String, Integer> dist = new HashMap<>();

        for (String word : wordList) {
            if (word.equals(beginWord)) {
                dist.put(word, 0);
            } else {
                dist.put(word, Integer.MAX_VALUE);
            }

        }

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        marked.put(beginWord, true);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String word : g.edges(current)) {

                if (!marked.getOrDefault(word, false)) {
                    marked.put(word, true);
                    dist.put(word, dist.get(current) + 1);
                    queue.offer(word);
                }
            }
        }

        if (!marked.getOrDefault(endWord, false) || dist.get(endWord) == Integer.MAX_VALUE) {
            return 0;
        } else {
            return dist.get(endWord) + 1;
        }
    }

    public static class Graph {

        private Map<String, Set<String>> graph;

        public Graph(List<String> wordList) {
            graph = new HashMap<>();
            wordList.forEach(s -> graph.put(s, new HashSet<>()));

            Set<String> tempSet = new HashSet<>(wordList);

            for (String word : wordList) {
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int i = 0; i < word.length(); i++) {
                        if (c == word.charAt(i)) {
                            continue;
                        } else {
                            String temp = replace(word, i, c);
                            if (tempSet.contains(temp)) {
                                addEdge(word, temp);
                                addEdge(temp, word);
                            }
                        }
                    }
                }
            }
        }

        private String replace(String s, int index, char c) {
            char[] chars = s.toCharArray();
            chars[index] = c;
            return new String(chars);
        }

        public void addEdge(String vertex, String edge) {
            graph.get(vertex).add(edge);
        }

        public Set<String> edges(String vertex) {
            return graph.get(vertex);
        }
    }

    public static void main(String[] args) {
        _127_Word_Ladder q = new _127_Word_Ladder();

        String beginWord = "hit";

        String endWord = "cog";

        List<String> wordList = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));

        System.out.println(q.ladderLength(beginWord, endWord, wordList));

    }

}
