package leetcode;

public class _303_Range_Sum_Query {


  FenwickTree ftree;

  public _303_Range_Sum_Query(int[] nums) {
    ftree = new FenwickTree(nums);
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return ftree.getSum(j);
    } else {
      return ftree.getSum(j) - ftree.getSum(i - 1);
    }
  }

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
  }

}
