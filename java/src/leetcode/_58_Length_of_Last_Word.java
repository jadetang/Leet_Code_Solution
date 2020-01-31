package leetcode;

import level.Easy;

public class _58_Length_of_Last_Word implements Easy {

  public int lengthOfLastWord(String s) {
    String[] str = s.split("\\s");
    if (str == null || str.length == 0) {
      return 0;
    } else {
      return str[str.length - 1].length();
    }
  }
}
