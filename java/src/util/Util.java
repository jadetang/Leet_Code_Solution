package util;

import ds.TreeNode;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author jade on 2017/5/3 下午10:31
 */
public class Util {

  public static <T> T runWithTime(Supplier<T> supplier) {
    long time = System.currentTimeMillis();
    T t = supplier.get();
    System.out.println("take time:" + (System.currentTimeMillis() - time));
    return t;
  }

  public static int[] randomArray(int length) {
    Random random = new Random();
    int[] array = new int[length];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt();
    }
    return array;
  }

  public static int partition(int[] nums) {
    int l = -1;
    int r = nums.length;
    while (true) {
      while (nums[++l] > 0) {
        if (l == nums.length) {
          break;
        }
      }
      while (nums[--r] <= 0) {
        if (r == 0) {
          break;
        }
      }
      if (l >= r) {
        break;
      }
      swap(nums, l, r);
    }
    return l;
  }

  public static void print(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        System.out.print("[" + array[i] + ",");
      } else if (i == array.length - 1) {
        System.out.println(array[i] + "]");
      } else {
        System.out.print(array[i] + ",");
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void print(TreeNode treeNode) {
    while (treeNode != null){
      System.out.print(treeNode.val+" ");
      treeNode = treeNode.right;
    }
  }
}
