package solution;

/**
 * @author jade on 16/9/14 下午8:44
 */
public class _27_Remove_Element {


  //每次都把数组的最后一位元素放到前面来，避免了数组的 copy
  public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1];
        // reduce nums size by one
        n--;
      } else {
        i++;
      }
    }
    return n;

  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 2, 3};
    _27_Remove_Element q = new _27_Remove_Element();
    int result = q.removeElement(nums, 3);
    System.out.println("result:" + result);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
