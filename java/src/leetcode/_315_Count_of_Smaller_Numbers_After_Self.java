package leetcode;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jade on 2017/7/7 下午5:19
 */
public class _315_Count_of_Smaller_Numbers_After_Self {

  //TLE
  public static List<Integer> countSmaller(int[] nums) {
    TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!tree.containsKey(nums[i])) {
        tree.put(nums[i], new LinkedList<>());
      }
      tree.get(nums[i]).add(i);
    }
    List<Integer> list = new LinkedList<>();
    System.out.println(tree.headMap(26));
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      Collection<List<Integer>> set = tree.headMap(nums[i]).values();

      for (List<Integer> list1 : set) {
        for (int index : list1) {
          if (index > i) {
            count++;
          }
        }

      }
      list.add(count);
    }
    return list;
  }

  public static void main(String[] args) {
    int[] in = new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98,
        69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
    System.out.println(countSmaller(in));
  }

}
