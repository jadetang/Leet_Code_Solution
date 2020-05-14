package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_Brick_Walls {

  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (List<Integer> row : wall) {
      int offset = 0;
      int count = 0;
      for (int i : row) {
        if (count > 0) {
          hashMap.put(offset, hashMap.getOrDefault(offset, 0) + 1);
        }
        offset += i;
        count++;
      }
    }
    int ans = wall.size();
    for (int i : hashMap.values()) {
      ans = Math.min(ans, wall.size() - i);
    }
    return ans;
  }

}
