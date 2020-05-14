package ds;

import java.util.HashMap;
import java.util.Map;

public class Counter {

  private Map<Integer, Integer> map = new HashMap<>();

  public int count(int val) {
    return map.getOrDefault(val, 0);
  }

  public void increase(int val) {
    map.put(val, map.getOrDefault(val, 0) + 1);
  }

  public void decrease(int val) {
    if (map.containsKey(val) && map.get(val) > 0) {
      map.put(val, map.get(val) - 1);
    }
  }
}
