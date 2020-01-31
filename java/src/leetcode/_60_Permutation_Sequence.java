package leetcode;

/**
 * @author jade on 2017/5/17 下午4:38
 */
public class _60_Permutation_Sequence {

  int count = 0;

  public static void main(String[] args) {
    _60_Permutation_Sequence q = new _60_Permutation_Sequence();
    //   System.out.println(q.getPermutation(3, 1));
    System.out.println(q.getPermutation(3, 100));
  }

  public String getPermutation(int n, int k) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    boolean finish = false;
    int count = 0;
    String result = null;
    while (!finish) {
      count++;
      if (count == k) {
        finish = true;
        result = arrayToString(nums);
      } else {
        System.out.println(arrayToString(nums));
        int i = nums.length - 2;
        for (; i >= 0; i--) {
          if (nums[i] < nums[i + 1]) {
            break;
          }
        }
        if (i == -1) {
          finish = true;
        } else {
          int ceilIndex = findCeil(nums, i);
          swap(nums, i, ceilIndex);
          reverse(nums, i + 1, nums.length - 1);
        }
      }
    }
    return result;
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private int findCeil(int[] nums, int startIndex) {
    int ceil = startIndex + 1;
    for (int j = ceil; j < nums.length; j++) {
      if (nums[j] > nums[startIndex] && nums[j] < nums[ceil]) {
        ceil = j;
      }
    }
    return ceil;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private String arrayToString(int[] nums) {

    StringBuilder sb = new StringBuilder();
    for (int n : nums) {
      sb.append(n);
    }
    return sb.toString();
  }

}
