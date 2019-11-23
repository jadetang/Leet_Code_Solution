package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jade on 2017/7/30 下午8:58
 */
public class _645_Set_Mismatch {


  //把和给算出来，另外也能用 index array 来做，记录 frequency
  public static int[] findErrorNums(int[] nums) {
    int n = nums.length;
    int sum = n * (1 + n) / 2;
    Set set = new HashSet();
    int duplicate = -1;
    for (int i : nums) {
      if (set.contains(i)) {
        duplicate = i;
      }
      set.add(i);
      sum -= i;
    }
    return new int[]{duplicate, sum + duplicate};
  }

  public static void main(String[] args) {
    int[] array = new int[]{2, 2};
    findErrorNums(array);
  }


}
