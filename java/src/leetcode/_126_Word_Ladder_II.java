package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _126_Word_Ladder_II {

    @Test
    public void test() {
        _126_Word_Ladder_II q = new _126_Word_Ladder_II();
        String begin = "hit";
        String end = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        Assert.assertEqual(2, q.findLadders(begin, end, wordList).size());
    }

    @Test
    public void test2() {
        _126_Word_Ladder_II q = new _126_Word_Ladder_II();
        String begin = "red";
        String end = "tax";
        List<String> wordList = List.of("ted","tex","red","tax","tad","den","rex","pee");
        Assert.assertEqual(3, q.findLadders(begin, end, wordList).size());
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return ans;
        }
        Queue<List<String>> path = new LinkedList<>();
        List<String> startPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        startPath.add(beginWord);
        path.add(startPath);
        boolean found = false;
        while (!path.isEmpty() && !found) {
            Set<String> tempSet = new HashSet<>();
            int size = path.size();
            for (int i = 0; i < size; i++) {
                List<String> lastPath = path.poll();
                String lastWord = lastPath.get(lastPath.size() - 1);
                char[] chars = lastWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    for (char nc = 'a'; nc <= 'z'; nc++) {
                        if (nc == c) {
                            continue;
                        }
                        chars[j] = nc;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord) ) {
                            lastPath.add(nextWord);
                            ans.add(lastPath);
                            found = true;
                            continue;
                        }
                        if (dictionary.contains(nextWord) && !visited.contains(nextWord)) {
                            tempSet.add(nextWord);
                            List<String> newPath = new ArrayList<>(lastPath);
                            newPath.add(nextWord);
                            path.add(newPath);
                        }
                    }
                    chars[j] = c;
                }
            }
            visited.addAll(tempSet);
        }
        return ans;
    }

}
