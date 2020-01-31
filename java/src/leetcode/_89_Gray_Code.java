package leetcode;

import company.Amazon;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import level.Medium;

public class _89_Gray_Code implements Medium, Amazon {

  public static void main(String[] args) {
    _89_Gray_Code solution = new _89_Gray_Code();
    System.out.println(solution.grayCode(0));
  }

  public List<Integer> grayCode(int n) {

    List<String> list = new LinkedList<>();
    list.add("0");
    list.add("1");
    for (int i = 1; i < n; i++) {
      list = generate(list);
    }
    return list.stream().map(s -> Integer.valueOf(s, 2)).collect(Collectors.toList());
  }

  private List<String> generate(List<String> l1) {
    List<String> l2 = new LinkedList<>(l1);
    Collections.reverse(l2);
    l2 = l2.stream().map(s -> "1" + s).collect(Collectors.toList());
    l1 = l1.stream().map(s -> "0" + s).collect(Collectors.toList());
    l1.addAll(l2);
    return l1;
  }


}
