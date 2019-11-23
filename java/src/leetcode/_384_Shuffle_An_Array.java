package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jade on 2016/11/13 下午5:00
 */
public class _384_Shuffle_An_Array {

  public static class Solution {

    int[] nums;

    public Solution(int[] nums) {
      this.nums = nums;
    }

    /**
     * Resets the nums to its original configuration and return it.
     */
    public int[] reset() {
      return nums;
    }

    /**
     * Returns a random shuffling of the nums.
     */
    public int[] shuffle() {
      int[] shuffle = Arrays.copyOf(nums, nums.length);
      Random random = new Random();
      for (int i = 0; i < shuffle.length; i++) {
        int r = i + random.nextInt(shuffle.length - i);
        int temp = shuffle[r];
        shuffle[r] = shuffle[i];
        shuffle[i] = temp;
      }
      return shuffle;
    }
  }
}
