package leetcode;

import java.util.Arrays;

public class _875_Koko_Eating_Bananas {

  public int minEatingSpeed(int[] piles, int H) {
    int max = Arrays.stream(piles).max().getAsInt();
    int l = 1;
    int r = max + 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int h = 0;
      for (int pile : piles) {
        h += (pile + mid - 1) / mid;
      }
      if (h <= H) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

}
