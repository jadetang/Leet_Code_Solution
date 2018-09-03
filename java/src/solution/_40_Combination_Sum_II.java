package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T. Each number in C may only be used once in the
 * combination. Note: All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. For example, given candidate set [10, 1, 2, 7, 6, 1, 5]
 * and target 8, A solution set is:
 *
 * @author jade on 2017/7/8 上午9:14
 */
public class _40_Combination_Sum_II {

  int nums[];

  int target;

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> acc = new LinkedList<>();
    Arrays.sort(candidates);
    this.nums = candidates;
    this.target = target;
    help(acc, new LinkedList<>(), 0, 0);
    return acc;
  }

  private void help(List<List<Integer>> acc, LinkedList<Integer> templist, int cur, int start) {
    System.out.println(templist);
    if (cur == target) {
      acc.add(new LinkedList<>(templist));
    } else if (cur > target) {
      return;
    } else {
      for (int i = start; i < nums.length; i++) {

        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }

        templist.add(nums[i]);

        help(acc, templist, cur + nums[i], i + 1);

        templist.removeLast();

        while (i < this.nums.length - 1 && this.nums[i] == this.nums[i + 1]) {
          i++;
        }
      }
    }

  }

  public static void main(String[] args) {
    int[] a = new int[]{10, 1, 2, 7, 6, 1, 5};
    _40_Combination_Sum_II q = new _40_Combination_Sum_II();
    q.combinationSum2(a, 8);
  }

}
