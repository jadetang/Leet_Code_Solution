package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jade on 2016/11/17 下午8:51
 */
public class _216_Combination_Sum_III {

  int k;
  int n;

  public static void main(String[] args) {
    _216_Combination_Sum_III q = new _216_Combination_Sum_III();
    System.out.println(q.combinationSum3(3, 9));
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    this.k = k;
    this.n = n;
    List<List<Integer>> acc = new LinkedList<>();
    dfs(acc, new ArrayList<>(), 0);
    return acc;
  }


  private void dfs(List<List<Integer>> acc, List<Integer> candidates, int level) {
    if (candidates.size() == this.k) {
      int sum = candidates.stream().reduce((integer, integer2) -> integer + integer2).get();
      if (sum == this.n) {
        acc.add(new LinkedList<>(candidates));
      }
    } else {
      for (int i = level + 1; i <= 9; i++) {
        candidates.add(i);
        dfs(acc, candidates, i);
        candidates.remove(candidates.size() - 1);
      }
    }
  }
}
