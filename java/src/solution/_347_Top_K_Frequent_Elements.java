package solution;

import java.util.*;

/**
 * @author jade on 2016/11/13 下午4:41
 */
public class _347_Top_K_Frequent_Elements {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> hash = new HashMap<>();
    for (int i : nums) {
      hash.put(i, hash.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Frequent> q = new PriorityQueue<>();

    for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
      q.add(new Frequent(entry.getKey(), entry.getValue()));
    }
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      result.add(q.poll().value);
    }
    return result;
  }

  public static class Frequent implements Comparable<Frequent> {

    public int value;
    public int frequent;

    public Frequent(int value, int frequent) {
      this.value = value;
      this.frequent = frequent;
    }

    @Override
    public int compareTo(Frequent o) {
      return o.frequent - this.frequent;
    }
  }

}
