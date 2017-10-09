package solution;

import java.util.HashSet;
import java.util.Set;

import level.Medium;
import tag.Array;
import util.Util;

/**
 * 思路，将值为x的数放在下标x-1的位置，即：A[i]存放的应该是i+1这个数。
 *
 * @author sanguan.tangsicheng on 2017/5/3 下午10:53
 */
public class _41_First_Missing_Positive implements Array, Medium {

  public int firstMissingPositive(int[] nums) {
    Util.print(nums);
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
        Util.print(nums);
      }
    }
    Util.print(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  public int firstMissingPositive2(int[] nums) {
    Set<Integer> s = new HashSet<>();
    int result = 1;
    for (int i : nums) {
      if (i > 0) {
        s.add(i);
        int temp = 1;
        while (s.contains(temp)) {
          temp++;
        }
        if (temp == i) {
          result = i + 1;
        } else {
          result = temp;
        }
      }
    }
    return result;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {0, 3, 5, 4};
    _41_First_Missing_Positive q = new _41_First_Missing_Positive();
    System.out.println(q.firstMissingPositive2(nums));
  }

}
