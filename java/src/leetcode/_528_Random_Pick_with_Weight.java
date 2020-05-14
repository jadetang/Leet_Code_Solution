package leetcode;

import java.util.Random;
import java.util.stream.IntStream;
import org.junit.Test;

public class _528_Random_Pick_with_Weight {

  @Test
  public void test() {
    int[] array = new int[]{2, 1};
    Solution q = new Solution(array);
    int i0 = 0;
    int i1 = 0;
    for (int i = 0; i < 100; i++) {
      int index = q.pickIndex();
      if (index == 0) {
        i0++;
      } else if (index == 1) {
        i1++;
      } else {
        throw new RuntimeException("xx");
      }
    }
    System.out.println(i0 + ":" + i1);
  }


  public class Solution {

    int sum = 0;
    int[] array;
    Random random = new Random();

    public Solution(int[] w) {
      this.sum = IntStream.of(w).sum();
      this.array = w;
    }

    public int pickIndex() {
      int tempSum = sum;
      for (int i = 0; i < array.length; i++) {
        int r = random.nextInt(tempSum);
        if (array[i] > r) {
          return i;
        }
        tempSum -= array[i];
      }
      return -1;
    }
  }
}
