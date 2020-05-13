package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _843_Guess_the_Word {

  Map<String, Integer> cache = new HashMap<>();

  public void findSecretWord(String[] wordlist, Master master) {
    guess(List.of(wordlist), master);
  }

  private void guess(List<String> wordlist, Master master) {
    if (wordlist.isEmpty()) {
      return;
    }
    String word = bestWord(wordlist);
    int hit = master.guess(word);
    if (hit == 6) {
      return;
    }
    List<String> nextList = wordlist.stream().filter(s -> similarity(word, s) == hit).collect(
        Collectors.toList());
    guess(nextList, master);
  }

  private String bestWord(List<String> wordlist) {
    if (wordlist.size() == 1) {
      return wordlist.get(0);
    }
    Map<String, int[]> similarityList = new HashMap<>();
    for (String word : wordlist) {
      for (String nextWord : wordlist) {
        if (!word.equals(nextWord)) {
          similarityList.computeIfAbsent(word, k -> new int[6])[similarity(word, nextWord)]++;
        }
      }
    }
    return similarityList.entrySet().stream().sorted((e1, e2) -> {
      int maxSimilarity1 = IntStream.of(e1.getValue()).max().getAsInt();
      int maxSimilarity2 = IntStream.of(e2.getValue()).max().getAsInt();
      if (maxSimilarity1 == maxSimilarity2) {
        return IntStream.of(e1.getValue()).sum() - IntStream.of(e2.getValue()).sum();
      } else {
        return maxSimilarity1 - maxSimilarity2;
      }
    }).findFirst().get().getKey();
  }

  public int similarity(String left, String right) {

    String key = key(left, right);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    int similarity = 0;
    for (int i = 0; i < left.length(); i++) {
      if (left.charAt(i) == right.charAt(i)) {
        similarity++;
      }
    }
    cache.put(key, similarity);
    return similarity;
  }

  private String key(String left, String right) {
    if (left.compareTo(right) > 0) {
      return left + ":" + right;
    } else {
      return right + ":" + left;
    }
  }

  interface Master {

    int guess(String word);
  }
}
