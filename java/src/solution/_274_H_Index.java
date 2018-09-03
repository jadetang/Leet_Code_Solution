package solution;

import java.util.Arrays;

/**
 * @author jade on 2017/7/31 上午8:31
 */
public class _274_H_Index {

  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    } else {
      Arrays.sort(citations);
      int i = 0;
      while (i < citations.length && citations[citations.length - i - 1] > i) {
        i++;
      }
      return i;
    }
  }
}
