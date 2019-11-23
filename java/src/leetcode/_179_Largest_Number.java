package leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jade on 2017/7/2 下午11:18
 */
public class _179_Largest_Number {


  public String largestNumber(int[] nums) {
    List<String> list = IntStream.of(nums).boxed().map(i -> i + "").collect(Collectors.toList());
    list.sort((l1, l2) -> {
      String s1 = l1 + l2;
      String s2 = l2 + l1;
      return s2.compareTo(s1);
    });
    return list.stream().reduce((l1, l2) -> {
      String s = l1 + l2;
      return s.equals("00") ? "0" : s;
    }).get();
  }
}
