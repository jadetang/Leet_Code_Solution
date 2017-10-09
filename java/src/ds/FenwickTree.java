package ds;

/**
 * @author sanguan.tangsicheng on 2017/6/23 上午8:49
 */
public class FenwickTree {

  int[] bit;

  public FenwickTree(int nums[]) {
    bit = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      update(i, nums[i]);
    }
  }

  public void update(int i, int value) {
    int index = i + 1;
    while (index < bit.length) {
      System.out.println(String.format("[%d,%d]", index, value));
      bit[index] += value;
      index += index & (-index);
    }
  }

  public int getSum(int index) {
    int sum = 0;
    index++;
    while (index > 0) {
      sum += bit[index];
      index -= index & (-index);
    }
    return sum;
  }

  public static void main(String[] args) {
    int freq[] = {1, 2, 3, 4, 5};
    FenwickTree tree = new FenwickTree(freq);
    System.out.println(tree.getSum(0));
    System.out.println(tree.getSum(2));
  }

}
