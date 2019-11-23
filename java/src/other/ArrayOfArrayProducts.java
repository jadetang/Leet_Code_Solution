package other;

import java.util.Arrays;

public class ArrayOfArrayProducts {


  static int[] arrayOfArrayProducts(int[] arr) {
    int n = arr.length;
    if (n == 0 || n == 1) {
      return new int[]{};
    }
    int[] result = new int[n];
    int product = 1;
    for (int i = 0; i < n; i++) {
      result[i] = product;
      product *= arr[i];
    }
    System.out.println(Arrays.toString(result));
    product = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= product;
      product *= arr[i];
    }
    System.out.println(Arrays.toString(result));
    return result;
  }

}
