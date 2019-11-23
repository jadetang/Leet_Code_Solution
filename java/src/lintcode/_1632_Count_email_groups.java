package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import util.Assert;

public class _1632_Count_email_groups {


  public static void main(String[] args) {
    _1632_Count_email_groups q = new _1632_Count_email_groups();
    Assert.assertEqual("abcbc@jiuzhang.com", q.transform("abc.bc+c+d@jiuzhang.com"));
    Assert.assertEqual("abcbc@jiuzhang.com", q.transform("abcbc+d@jiuzhang.com"));
    Assert.assertEqual("abcbccd@jiuzhang.com", q.transform("abc.bc.cd@jiuzhang.com"));
    List<String> emails = new ArrayList<>();
    emails.add("abc.bc+c+d@jiuzhang.com");
    emails.add("abcbc+d@jiuzhang.com");
    emails.add("abc.bc.cd@jiuzhang.com");
    Assert.assertEqual(1, q.countGroups(emails));


  }

  public int countGroups(List<String> emails) {
    List<String> transformedEmails = emails.stream().map(this::transform)
        .collect(Collectors.toList());
    Map<String, Integer> groupedEmails = new HashMap<>();
    for (String email : transformedEmails) {
      groupedEmails.put(email, groupedEmails.getOrDefault(email, 0) + 1);
    }
    return (int) groupedEmails.values().stream().filter(count -> count > 1).count();
    // Write your code here
  }

  private String transform(String email) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < email.length(); i++) {
      char c = email.charAt(i);
      if (c == '.') {
        continue;
      }
      if (c == '+') {
        while (i < email.length() - 1 && email.charAt(i + 1) != '@') {
          i++;
        }
        continue;
      }
      if (c == '@') {
        while (i < email.length()) {
          sb.append(email.charAt(i));
          i++;
        }
        break;
      }
      sb.append(c);
    }
    return sb.toString();
  }

}
