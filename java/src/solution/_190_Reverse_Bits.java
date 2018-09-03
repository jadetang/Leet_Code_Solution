package solution;

/**
 * @author jade on 2017/7/3 上午7:40
 */
public class _190_Reverse_Bits {


  public int reverseBits(int n) {

    int result = 0;
    for (int i = 0; i < 32; i++) {
      result += n & 1;
      n = n >>> 1;
      if (i == 31) {
        result = result << 1;
      }
    }
    return result;
  }
}
