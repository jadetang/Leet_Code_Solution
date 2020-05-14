package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import util.Assert;

public class _809_Expressive_Words {

  @Test
  public void test() {
    _809_Expressive_Words q = new _809_Expressive_Words();
    String s = "heeellooo";
    String[] words = new String[]{"hello", "hi", "helo"};
    Assert.assertEqual(1, q.expressiveWords(s, words));
  }

  @Test
  public void test2() {
    _809_Expressive_Words q = new _809_Expressive_Words();
    String s = "zzzzzyyyyy";
    String[] words = new String[]{"zzyy", "zy", "zyy"};
    Assert.assertEqual(3, q.expressiveWords(s, words));
  }

  public int expressiveWords(String s, String[] words) {
    List<Tuple> targetTuples = transform(s);
    int count = 0;
    for (String word : words) {
      if (canExpress(transform(word), targetTuples)) {
        count++;
      }
    }
    return count;
  }

  boolean canExpress(List<Tuple> source, List<Tuple> target) {
    if (source.size() != target.size()) {
      return false;
    }
    for (int i = 0; i < source.size(); i++) {
      Tuple sourceTuple = source.get(i);
      Tuple targetTuple = target.get(i);
      if (sourceTuple.c != targetTuple.c) {
        return false;
      }
      if (sourceTuple.count > targetTuple.count) {
        return false;
      }
      if (sourceTuple.count != targetTuple.count && targetTuple.count < 3) {
        return false;
      }
    }
    return true;
  }

  List<Tuple> transform(String s) {
    List<Tuple> tuples = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
        tuples.get(tuples.size() - 1).count++;
      } else {
        tuples.add(new Tuple(s.charAt(i)));
      }
    }
    return tuples;
  }

  public static class Tuple {

    char c;
    int count;

    public Tuple(char c) {
      this.c = c;
      this.count = 1;
    }
  }
}
