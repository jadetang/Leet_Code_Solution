package solution;

import ds.FenwickTree;

public class _307_Range_Sum_Query_Mutable {

  private FenwickTree fenwickTree;

  private int[] nums;


  public _307_Range_Sum_Query_Mutable(int[] nums) {
    this.fenwickTree = new FenwickTree(nums);
    this.nums = nums;
  }

  public void update(int i, int val) {
    int diff = val - nums[i];
    nums[i] = val;
    this.fenwickTree.update(i, diff);
  }

  public int sumRange(int i, int j) {
    return this.fenwickTree.getSum(j) - this.fenwickTree.getSum(i - 1);
  }

}
