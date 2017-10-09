package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.Util;

/**
 * @author sanguan.tangsicheng on 2017/6/23 上午7:40
 */
public class _47_Permutations_II {

  public static void main(String[] args) {
    _47_Permutations_II q = new _47_Permutations_II();
    int[] nums = new int[]{1, 1, 0, 0, 1, -1, -1, 1};
    Util.runWithTime((Supplier) () -> q.permuteUnique(nums));
    Util.runWithTime((Supplier) () -> q.permuteUnique2(nums));
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> lists = new LinkedList<>();
    boolean finish = false;
    while (!finish) {
      List<Integer> temp = IntStream.of(nums).boxed().collect(Collectors.toList());
      lists.add(temp);
      int i = 0;
      for (i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
          break;
        }
      }
      if (i == -1) {
        finish = true;
      } else {
        int ceil = findCeil(nums, i);
        swap(nums, ceil, i);
        Arrays.sort(nums, i + 1, nums.length);

      }

    }
    return lists;

  }

  private int findCeil(int[] nums, int i) {
    int pivot = nums[i];
    int index = i + 1;
    for (int j = i + 1; j < nums.length; j++) {
      if (pivot < nums[j] && nums[j] < nums[index]) {
        index = j;
      }
    }
    return index;

  }

  Set<List<Integer>> set = new HashSet<>();

  //TLE
  public List<List<Integer>> permuteUnique2(int[] nums) {
    Arrays.sort(nums);

    permutation(nums, 0, nums.length - 1);

    return new LinkedList<>(set);
  }

  private void permutation(int[] nums, int l, int r) {
    if (l == r) {
      List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
      if (!set.contains(list)) {
        set.add(list);
      }

    } else {

      for (int i = l; i <= r; i++) {
        swap(nums, i, l);
        permutation(nums, l + 1, r);
        swap(nums, i, l);
      }

    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
