package leetcode;

import java.util.BitSet;

/**
 * @author jade on 2016/11/16 上午8:02
 */
public class _319_Bulb_Switcher {

  public static void main(String[] args) {
    _319_Bulb_Switcher q = new _319_Bulb_Switcher();
    System.out.println(q.bulbSwitch(10000000));
    System.out.println(Math.sqrt(10000000));
  }

  public int bulbSwitch(int n) {
    BitSet set = new BitSet(n);
    for (int i = 1; i <= n; i++) {
      for (int j = i - 1; j < n; j += i) {
        set.flip(j);
      }
    }
    return set.cardinality();
  }
}
