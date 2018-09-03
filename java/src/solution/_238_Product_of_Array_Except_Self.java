package solution;

/**
 * @author jade on 2017/7/5 下午10:41
 */
public class _238_Product_of_Array_Except_Self {


  //遍历两遍，从左到右，从右到左。累积乘。
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    if (nums.length == 1) {
      return res;
    } else {
      int prefixProduct = 1;
      for (int i = 0; i < nums.length; i++) {
        res[i] = prefixProduct;
        prefixProduct *= nums[i];
      }
      int suffixProduct = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
        res[i] *= suffixProduct;
        suffixProduct *= nums[i];
      }
      return res;
    }
  }

}