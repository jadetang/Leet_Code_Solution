package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import org.junit.Test;

public class _642_Design_Search_Autocomplete_System {

  @Test
  public void test(){
    String[] sentence = new String[]{"i love you", "island", "ironman", "i love leetcode"};
    int[] hot = new int[] {5, 3, 2, 2};
    AutocompleteSystem system = new AutocompleteSystem(sentence, hot);
    System.out.println(system.input('i'));
    System.out.println(system.input(' '));
    System.out.println(system.input('a'));
    System.out.println(system.input('#'));
    System.out.println(system.input('i'));
    System.out.println(system.input(' '));
  }

  public static class AutocompleteSystem{

    TrieNode root;

    StringBuilder inputBuffer;
    public AutocompleteSystem(String[] sentences, int[] times) {
      root = new TrieNode();
      for (int i = 0; i < sentences.length; i++) {
        insert(new Record(sentences[i], times[i]));
      }
      inputBuffer = new StringBuilder();
    }

    private void insert(Record record) {
      String sentence = record.sentence;
      TrieNode node = root;
      for (int i = 0; i < sentence.length(); i++) {
        if (node.nodes[index(sentence.charAt(i))] == null) {
          node.nodes[index(sentence.charAt(i))] = new TrieNode();
        }
        node = node.nodes[index(sentence.charAt(i))];
        node.add(record);
      }
    }

    public List<String> input(char c) {
      if (c == '#') {
        String query = inputBuffer.toString();
        inputBuffer = new StringBuilder();
        insert(new Record(query, 1));
        return Collections.emptyList();
      }else {
        String query = inputBuffer.append(c).toString();
        return query(query);
      }
    }

    private List<String> query(String query) {
      TrieNode node = root;
      for (char c : query.toCharArray()) {
        node = node.nodes[index(c)];
        if (node == null) {
          return Collections.emptyList();
        }
      }
      return node.map.values().stream().sorted()
          .limit(3).map(r -> r.sentence).collect(Collectors.toList());
    }

    private int index(char c) {
      if (c == ' ') {
        return 26;
      }
      return c - 'a';
    }

    public static class TrieNode {
      TrieNode[] nodes;
      Map<String, Record> map;

      public TrieNode() {
        nodes = new TrieNode[27];
        map = new HashMap<>();
      }

      public void add(Record record) {
        Record oldRecord = map.get(record.sentence);
        if (oldRecord != null) {
          map.put(record.sentence, new Record(record.sentence, record.hot + oldRecord.hot));
        }else {
          map.put(record.sentence, record);
        }
      }
    }

    public static class Record implements Comparable<Record>{
      String sentence;
      int hot;

      public Record(String sentence, int hot) {
        this.sentence = sentence;
        this.hot = hot;
      }

      @Override
      public int compareTo(Record o) {
        if (this.hot == o.hot) {
          return this.sentence.compareTo(o.sentence);
        }
        return o.hot - this.hot;
      }
    }
  }
}
