package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2016/12/3 上午10:26
 */
public class Combination {

  public List<List<Integer>> sum(int[][] nums, int target) {

    for (int[] row : nums) {
      Arrays.sort(row);
    }
    List<List<Integer>> result = new LinkedList<>();

    driver(nums, new ArrayList<>(), result, target, 0);

    return result;

  }


  private void driver(int[][] nums, List<Integer> temp, List<List<Integer>> list, int target,
      int level) {
    if (level == nums.length - 1) {
      int[] row = nums[level];
      for (int i = 0; i < row.length; i++) {
        if (row[i] == target) {
          temp.add(row[i]);
          list.add(new LinkedList<>(temp));
          temp.remove(temp.size() - 1);
        }
      }
    } else {
      int[] row = nums[level];
      for (int i = 0; i < row.length; i++) {
        if (row[i] <= target) {
          if ((i > 1 && row[i] != row[i - 1]) || i == 0) {
            temp.add(row[i]);
            driver(nums, temp, list, target - row[i], level + 1);
            temp.remove(temp.size() - 1);
          }
        } else {
          break;
        }
      }
    }
  }


  public static void main(String[] args) {
    Combination q = new Combination();
    int[][] nums = {{2, 3, 4}, {0, 0, 1}, {1, 2, 3}, {0, 0, 1}, {0, 0, 2}};
    q.sum(nums, 6).stream().forEach(System.out::println);
  }

}
