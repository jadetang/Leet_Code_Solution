package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;
import util.Assert;

public class _126_World_LadderII {

    @Test
    public void test() {
        _126_World_LadderII q = new _126_World_LadderII();
        var begin = "hit";
        var end = "cog";
        var words = List.of("hot","dot","dog","lot","log","cog");
        var ans = q.findLadders(begin, end, words);
        System.out.println(ans);
        Assert.assertEqual(2, ans.size());
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        int l = beginWord.length();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, String> path = new HashMap<>();
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < l; j++) {
                    char c = chars[j];
                    for (char nc = 'a'; nc <= 'z'; nc++) {
                        if (nc == c) {
                            continue;
                        }
                        chars[j] = nc;
                        String nextStr = new String(chars);
                        if (nextStr.equals(endWord) || dict.contains(nextStr)) {
                            path.put(nextStr,s);
                            found = nextStr.equals(endWord);
                            dict.remove(nextStr);
                            queue.offer(nextStr);
                        }
                        chars[j] = c;
                    }
                }
            }
        }
        return found ? ans : Collections.emptyList();
    }

}
