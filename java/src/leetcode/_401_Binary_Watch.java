package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2016/11/13 上午11:42
 */
public class _401_Binary_Watch {

  public List<String> readBinaryWatch(int num) {
    List<String> result = new LinkedList<>();
    for (int i = 0; i < 12; i++) {
      int n = getDigits(i);
      if (n == num) {
        result.add(i + ":00");
      }
      if (n > num) {
        continue;
      }
      if (n < num) {
        for (int j = 0; j <= 59; j++) {
          int m = getDigits(j);
          if (m == num - n) {
            result.add(i + ":" + m);
          }
        }
      }
    }
    return result;
  }

  private int getDigits(int i) {
    String str = Integer.toBinaryString(i);
    int count = 0;
    for (Character c : str.toCharArray()) {
      if (c == '1') {
        count++;
      }
    }
    return count;
  }
}
