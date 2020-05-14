package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import tag.Array;

public class _1048_Longest_String_Chain {


    @Test
    public void test() {
        String[] array = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
        _1048_Longest_String_Chain q = new _1048_Longest_String_Chain();
        Assert.assertEquals(4, q.longestStrChain(array));
    }

    @Test
    public void test2() {
        String[] array = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
        _1048_Longest_String_Chain q = new _1048_Longest_String_Chain();
        Assert.assertEquals(4, q.longestStrChain2(array));
    }

    public int longestStrChain2(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        cache = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(word.length(), length -> new HashSet<>()).add(word);
        }
        int ans = 1;
        Arrays.sort(words,(w1, w2) -> w2.length() - w1.length());
        for (String word : words) {
            ans = Math.max(ans, dfs2(word, map, 1));
        }
        return ans;
    }

    private int dfs2(String word, Map<Integer, Set<String>> map, int currentLength) {
        System.out.println(word + ":" + currentLength);
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        Set<String> nextWords = map.get(word.length() - 1);
        if (nextWords == null) {
            cache.put(word, currentLength);
            return currentLength;
        }
        int maxLength = currentLength;
        for (int i = 0; i < word.length(); i++) {
            String newWord = new StringBuilder(word).deleteCharAt(i).toString();
            if (nextWords.contains(newWord)) {
                maxLength = Math.max(maxLength, dfs2(newWord, map, currentLength + 1));
            }
        }
        cache.put(word, maxLength);
        return maxLength;
    }


    Map<String, Integer> cache;

    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        cache = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(word.length(), length -> new HashSet<>()).add(word);
        }
        int ans = 1;
        for (String word : words) {
            ans = Math.max(ans, dfs(word, map));
        }
        return ans;
    }

    private int dfs(String word, Map<Integer, Set<String>> map) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        int ans = 1;
        if (map.get(word.length() + 1) == null) {
            return ans;
        }
/*        for (String nextWord : map.get(word.length() + 1)) {
            if (canTransForm(word, nextWord)) {
                ans = Math.max(ans, dfs(nextWord, map) + 1);
            }
        }*/
        cache.put(word, ans);
        return cache.get(word);
    }

    private boolean canTransForm(String from, String toWord) {
        char[] fromChar = from.toCharArray();
        char[] toChar = toWord.toCharArray();
        int diff = 0;
        int i = 0, j = 0;
        for (; i < fromChar.length && j < toChar.length; i++, j++) {
            if (fromChar[i] != toChar[j]) {
                diff++;
                i--;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return (diff == 1 && j == toChar.length) || (diff == 0 && j == toChar.length - 1);
    }
}
