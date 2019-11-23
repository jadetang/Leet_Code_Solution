package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1236_Find_All_Numbers_Disappeared_in_an_Array {


  public static void main(String[] args) {
    int[] data = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    _1236_Find_All_Numbers_Disappeared_in_an_Array q = new _1236_Find_All_Numbers_Disappeared_in_an_Array();
    System.out.println(q.findDisappearedNumbers(data));
  }


  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums.length == 0) {
      return res;
    }
    Arrays.sort(nums);
    int[] sort = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sort[i] = i + 1;
    }
    int j = 0;
    for (int i = 0; i < nums.length && j < sort.length; ) {
      System.out.printf("[%d,%d]\n", i, j);
      if (nums[i] == sort[j]) {
        i++;
        j++;
        while (i < nums.length && nums[i - 1] == nums[i]) {
          i++;
        }
      } else {
        res.add(sort[j++]);
      }
    }
    while (j < sort.length) {
      res.add(sort[j++]);
    }
    return res;
  }

}
