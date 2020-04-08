package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class _68_Text_Justification {

  @Test
  public void test() {
    _68_Text_Justification q = new _68_Text_Justification();
    List<String> buffer = List.of("This", "is", "an");
    int maxWidth = 16;
    Assert.assertEquals("This    is    an", q.flush(buffer, 8,16));

    List<String> buffer2 = List.of("acknowledgment");
    Assert.assertEquals("acknowledgment  ", q.flush(buffer2, "acknowledgment".length(),16));
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> buffer = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int currentLength = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.length() + currentLength + buffer.size() > maxWidth) {
        ans.add(flush(buffer, currentLength, maxWidth));
        buffer.clear();
        currentLength = 0;
      }
      buffer.add(word);
      currentLength += word.length();
    }
    if (!buffer.isEmpty()) {
      ans.add(flush(buffer, maxWidth));
    }
    return ans;
  }

  String flush(List<String> buffer, int maxWidth) {
    StringBuilder line = new StringBuilder(String.join(" ", buffer));
    while (line.length() < maxWidth) {
      line.append(" ");
    }
    return line.toString();
  }

  String flush(List<String> buffer, int wordLength, int maxWidth) {
    int wordNumber = buffer.size();
    int spaceNumber = maxWidth - wordLength;
    int spacePerSlot = 0;
    int extraSpace = 0;
    if (wordNumber > 1) {
       spacePerSlot = spaceNumber / (wordNumber - 1);
       extraSpace = spaceNumber % (wordNumber - 1);
    }
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    for (String word : buffer) {
      stringBuilder.append(word);
      if (i < buffer.size() - 1) {
        stringBuilder.append(" ".repeat(spacePerSlot));
        if (extraSpace > 0) {
          stringBuilder.append(" ");
          extraSpace--;
        }
      }
      i++;
    }
    while (stringBuilder.length() < maxWidth) {
      stringBuilder.append(" ");
    }
    return stringBuilder.toString();
  }

}
