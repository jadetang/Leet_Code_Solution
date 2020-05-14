package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class _1087_Brace_Expansion {

  @Test
  public void test() {
    _1087_Brace_Expansion q = new _1087_Brace_Expansion();
    String str = "abc";
    Assert.assertArrayEquals(new String[]{"abc"}, q.expand(str));
  }

  @Test
  public void test2() {
    _1087_Brace_Expansion q = new _1087_Brace_Expansion();
    String str = "{a,b}c";
    Assert.assertArrayEquals(new String[]{"ac", "bc"}, q.expand(str));
  }

  @Test
  public void test3() {
    _1087_Brace_Expansion q = new _1087_Brace_Expansion();
    String str = "{a,b}c{d,e}f";
    Assert.assertArrayEquals(new String[]{"acdf", "acef", "bcdf", "bcef"}, q.expand(str));
  }

  public String[] expand(String s) {
    List<StringBuilder> builders = new ArrayList<>();
    builders.add(new StringBuilder());
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i++);
      if (c != '{' && c != '}') {
        builders.forEach(sb -> sb.append(c));
      } else {
        List<StringBuilder> newBuilders = new ArrayList<>();
        while (i < s.length() && s.charAt(i) != '}') {
          char tempC = s.charAt(i++);
          if (tempC == ',') {
            continue;
          }
          List<StringBuilder> tempBuilders = copy(builders);
          tempBuilders.forEach(sb -> sb.append(tempC));
          newBuilders.addAll(tempBuilders);
        }
        builders = newBuilders;
        i++;
      }
    }
    return builders.stream().map(StringBuilder::toString).sorted().collect(Collectors.toList())
        .toArray(String[]::new);
  }

  private List<StringBuilder> copy(List<StringBuilder> builders) {
    return builders.stream().map(StringBuilder::new).collect(Collectors.toList());
  }
}
