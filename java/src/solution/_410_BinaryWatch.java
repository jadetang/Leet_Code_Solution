package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 16/9/20 下午3:52
 */
public class _410_BinaryWatch {

  public List<String> readBinaryWatch(int num) {
    List<String> result = new LinkedList<>();
    for (int i = 0; i <= num; i++) {
      List<String> hours = findHour(i);
      List<String> minutes = findMinute(num - i);
      for (String hour : hours) {
        for (String minute :
            minutes) {
          result.add(hour + ":" + minute);
        }
      }
    }
    return result;
  }

  private List<String> findMinute(int i) {
    return null;
  }

  private List<String> findHour(int i) {
    return null;
  }
}
