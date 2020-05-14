package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _1406_Stone_Game_III {

  int n;
  int[] stone;
  Map<Integer, Integer> cache = new HashMap<>();

  @Test
  public void test() {
    int[] stones = new int[]{1, 2, 3, -1, -2, -3, 7};
    _1406_Stone_Game_III q = new _1406_Stone_Game_III();
    Assert.assertEqual("Alice", q.stoneGameIII(stones));
  }

  public String stoneGameIII(int[] stoneValue) {
    n = stoneValue.length;
    stone = stoneValue;
    return score(0) > 0 ? "Alice" : (score(0) < 0 ? "Bob" : "Tie");
  }

  private int score(int i) {
    if (i >= n) {
      return 0;
    }
    if (cache.containsKey(i)) {
      return cache.get(i);
    }

    int sum = 0;
    int max = 0;
    for (int j = 0; j < 3 && i + j < n; j++) {
      sum += stone[i + j];
      max = Math.max(max, sum - score(i + j + 1));
    }
    cache.put(i, max);
    return cache.get(i);
  }
}
