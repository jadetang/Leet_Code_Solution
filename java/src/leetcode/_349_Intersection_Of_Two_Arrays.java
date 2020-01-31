package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.Util;

/**
 * @author jade on 16/7/12 上午10:46
 */
public class _349_Intersection_Of_Two_Arrays {

  public static void main(String[] args) {

    _349_Intersection_Of_Two_Arrays q = new _349_Intersection_Of_Two_Arrays();
    int[] nums1 = new int[]{0, 1, 1, 2, 2, 5};
    int[] nums2 = new int[]{0, 1, 2, 2, 2, 6};
    Util.print(q.intersection(nums1, nums2));
    Util.print(q.intersection2(nums1, nums2));
  }

  public int[] intersection(int[] nums1, int[] nums2) {

    Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> set2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());
    set1.retainAll(set2);
    return toArray(set1);
  }

  private int[] toArray(Set<Integer> set1) {
    int[] result = new int[set1.size()];
    int index = 0;
    for (Integer i : set1) {
      result[index++] = i;
    }
    return result;
  }

  //还可以先排序一个，然后 2 分查找一个

  public int[] intersection2(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    IntStream.Builder b = IntStream.builder();
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        b.accept(nums1[i]);
        i++;
        j++;
      }
    }
    return b.build().toArray();
  }

}
