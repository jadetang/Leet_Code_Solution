package leetcode;

import java.util.BitSet;

/**
 * @author jade on 2017/7/4 上午8:23
 */
public class _217_Contains_Duplicate {

  public boolean containsDuplicate(int[] nums) {

    BitSet b = new BitSet();
    for (int num : nums) {
      if (b.get(num)) {
        return true;
      } else {
        b.set(num);
      }
    }
    return false;
  }
}
