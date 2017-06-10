package solution;

import java.util.*;

/**
 * @author sanguan.tangsicheng on 16/9/22 下午8:36
 */
public class _30_Substring_With_Concatenation_Of_All_Words {


    public List<Integer> findSubstring2(String s, String[] words) {
        int wordLength = words[0].length();
        int matchLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, 0);
        }
        for (String word : words) {
            wordCount.put(word, wordCount.get(word) + 1);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < wordLength; i++) {
            int index = i;
            while (index <= s.length() - matchLength - i) {
                int matchResult = match(s, index, wordLength, new HashMap<>(wordCount), words.length);
                if (matchResult == -1) {
                    index += wordLength;
                } else if (matchResult < index + matchLength) {
                    index = matchResult;
                } else {
                    result.add(index);
                    index += wordLength;
                }
            }
        }
        return result;
    }

    private int match(String s, int index, int wordLength, HashMap<String, Integer> words, int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            String word = s.substring(index, index + wordLength);
            if (words.containsKey(word)) {
                words.put(word, words.get(word) - 1);
            } else {
                return index;
            }
            index += wordLength;
        }
        boolean allMatch = words.values().stream().allMatch(integer -> integer.equals(0));
        if (!allMatch) {
            return -1;
        } else {
            return 0;
        }
    }


    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int matchLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, 0);
        }
        for (String word : words) {
            wordCount.put(word, wordCount.get(word) + 1);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i <= s.length() - matchLength; i++) {
            if (isValid(s, i, wordLength, new HashMap<>(wordCount), words.length)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isValid(String s, int index, int wordLength, Map<String, Integer> words, int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            String word = s.substring(index, index + wordLength);
            if (words.containsKey(word)) {
                words.put(word, words.get(word) - 1);
                if (words.get(word)<0){
                    return false;
                }
            } else {
                return false;
            }
            index += wordLength;
        }
        return words.values().stream().allMatch(integer -> integer.equals(0));
    }


    public static void main(String[] args) {

        _30_Substring_With_Concatenation_Of_All_Words q = new _30_Substring_With_Concatenation_Of_All_Words();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best", "good"};
        System.out.println(q.findSubstring(s, words));
        // System.out.println(q.findSubstring2(s, words));
    }
}
