package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合，不考虑顺序
 *
 * @author jade on 2016/11/19 下午11:17
 */
public class _39_Combination_Sum {

  int nums[];

  int target;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> acc = new LinkedList<>();
    Arrays.sort(candidates);
    this.nums = candidates;
    this.target = target;
    help(acc, new LinkedList<>(), 0, 0);
    return acc;
  }


  private void help(List<List<Integer>> acc, List<Integer> tempList, int cur, int start) {
    System.out.println(tempList);
    if (cur == target) {
      acc.add(new LinkedList<>(tempList));
    } else if (cur > target) {
      return;
    } else {
      for (int i = start; i < this.nums.length; i++) {
        tempList.add(this.nums[i]);
        help(acc, tempList, cur + nums[i], i);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {

    _39_Combination_Sum q = new _39_Combination_Sum();
    int[] a = new int[]{2, 3, 6, 7};
    q.combinationSum(a, 7);


  }

}
