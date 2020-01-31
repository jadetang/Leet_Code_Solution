package ds;

/**
 * @author jade on 2017/6/23 上午8:49
 */
public class FenwickTree {

  int[] bit;

  public FenwickTree(int nums[]) {
    bit = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      incr(i, nums[i]);
    }
  }

  public static void main(String[] args) {
    int freq[] = {1, 2, 3, 4, 5};
    FenwickTree tree = new FenwickTree(freq);
    System.out.println(tree.getSum(0));
    tree.incr(0, -1);
    System.out.println(tree.getSum(0));
    System.out.println(tree.getSum(2));
  }

  public void incr(int i, int value) {
    int index = i + 1;
    while (index < bit.length) {
      bit[index] += value;
      index += lowBit(index);
    }
  }


  private int lowBit(int i) {
    return i & (-i);
  }

  public int getSum(int index) {
    int sum = 0;
    index = index + 1;
    while (index > 0) {
      sum += bit[index];
      index -= lowBit(index);
    }
    return sum;
  }

}
