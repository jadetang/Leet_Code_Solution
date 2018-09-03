package solution;

/**
 * @author jade on 2017/7/3 上午7:55
 */
public class _191_Number_of_1_Bits {


  public int hammingWeight(int n) {
    int sum = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        sum++;
      }
      n = n >>> 1;
    }
    return sum;
  }
}
