package solution;

/**
 * @author jade on 2017/7/3 上午7:34
 */
public class _189_Rotate_Array {


  public void rotate(int[] nums, int k) {
    int step = k % nums.length; //算出 k 的步数，要取模
    if (step == 0 || nums.length == 1) {
      return;
    }
    reverse(nums, 0, nums.length - 1 - step);
    reverse(nums, nums.length - step, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] array, int from, int to) {
    for (int i = 0; i <= (to - from) / 2; i++) {
      exechange(array, from + i, to - i);
    }
  }

  private void exechange(int[] array, int l, int r) {
    if (l == r) {
      return;
    }
    int temp = array[l];
    array[l] = array[r];
    array[r] = temp;
  }
}
