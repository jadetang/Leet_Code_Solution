package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author jade on 2017/7/7 下午5:19
 */
public class _315_Count_of_Smaller_Numbers_After_Self {

  //TLE
  public static List<Integer> countSmaller2(int[] nums) {
    TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!tree.containsKey(nums[i])) {
        tree.put(nums[i], new LinkedList<>());
      }
      tree.get(nums[i]).add(i);
    }
    List<Integer> list = new LinkedList<>();
    System.out.println(tree.headMap(26));
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      Collection<List<Integer>> set = tree.headMap(nums[i]).values();
      for (List<Integer> list1 : set) {
        for (int index : list1) {
          if (index > i) {
            count++;
          }
        }

      }
      list.add(count);
    }
    return list;
  }

  public static void main(String[] args) {
    FenwickTree tree = new FenwickTree(10);
    tree.update(1, 10);
    tree.update(2, 10);
    System.out.println(tree.query(3));
    tree.update(2, -5);
    System.out.println(tree.query(3));
  }

  @Test
  public void test() {
    _315_Count_of_Smaller_Numbers_After_Self q = new _315_Count_of_Smaller_Numbers_After_Self();
    int[] nums = new int[]{5, 2, 6, 1};
    Assert.assertEquals(List.of(2, 1, 1, 0), q.countSmaller(nums));
  }

  public List<Integer> countSmaller(int[] nums) {
    int[] sorted = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sorted);
    Map<Integer, Integer> rank = new HashMap<>();
    int currentRank = 1;
    for (int i = 0; i < sorted.length; i++) {
      if (i > 0 && sorted[i] != sorted[i - 1]) {
        currentRank++;
      }
      rank.put(sorted[i], currentRank);
    }
    FenwickTree fenwickTree = new FenwickTree(currentRank);
    List<Integer> ans = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      int sum = fenwickTree.query(rank.get(nums[i]) - 1);
      ans.add(sum);
      fenwickTree.update(rank.get(nums[i]), 1);
    }
    Collections.reverse(ans);
    return ans;
  }

  public static class FenwickTree {

    int[] bit;

    public FenwickTree(int n) {
      bit = new int[n + 1];
    }

    public void update(int i, int delta) {
      while (i < bit.length) {
        bit[i] += delta;
        i += -i & i;
      }
    }

    public int query(int i) {
      int sum = 0;
      while (i > 0) {
        sum += bit[i];
        i -= -i & i;
      }
      return sum;
    }
  }


}
