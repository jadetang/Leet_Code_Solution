package solution;

/**
 * @author jade on 2016/12/15 上午7:58
 */
public class _371_Sum_Of_Integers {

  public int getSum(int a, int b) {
    return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
  }

  public static void main(String[] args) {
    _371_Sum_Of_Integers q = new _371_Sum_Of_Integers();
    System.out.println(q.getSum(101, 102));
  }
}
