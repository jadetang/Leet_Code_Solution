package leetcode;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;
import util.Assert;

public class _720_Longest_Word_in_Dictionary {

    @Test
    public void test() {
        _720_Longest_Word_in_Dictionary q = new _720_Longest_Word_in_Dictionary();
        String[] words = new String[] {"w","wo","wor","worl", "world"};
        Assert.assertEqual("world", q.longestWord(words));
    }

    @Test
    public void test1() {
        _720_Longest_Word_in_Dictionary q = new _720_Longest_Word_in_Dictionary();
        String[] words = new String[] {"w","wo","wor","worl", "world"};
        Assert.assertEqual("world", q.longestWord(words));
        String[] words2 = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Assert.assertEqual("apple", q.longestWord(words2));
        String[] words3 = new String[] {"a", "xa"};
        Assert.assertEqual("", q.longestWord(words3));
    }

    Map<String, Boolean> cache;

    public String longestWord(String[] words) {
        cache = new HashMap<>();
        Map<Integer, Set<String>> dictionary =  Stream.of(words).collect(groupingBy(String::length, toSet()));
        Arrays.sort(words, (w1, w2) -> {
            if (w2.length() == w1.length()) {
                return w1.compareTo(w2);
            }
            return w2.length() - w1.length();
        });
        for (String word : words) {
            if (word.length() > 1) {
                if (canBuild(word, dictionary)) {
                    return word;
                }
            }
        }
        return "";
    }

    private boolean canBuild(String currentWord, Map<Integer, Set<String>> dictinary) {
        if (cache.containsKey(currentWord)) {
            return cache.get(currentWord);
        }
        if (currentWord.length() == 1) {
            cache.put(currentWord, true);
            return cache.get(currentWord);
        }
        Set<String> preWords = dictinary.get(currentWord.length() - 1);
        if (preWords == null) {
            cache.put(currentWord, false);
            return cache.get(currentWord);
        }
        boolean canBuild = false;
        String preWord = currentWord.substring(0, currentWord.length() - 1);
        if (preWords.contains(preWord)) {
            canBuild = canBuild(preWord, dictinary);

        }
        cache.put(currentWord, canBuild);
        return cache.get(currentWord);
    }

}
