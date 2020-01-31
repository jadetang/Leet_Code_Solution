package company.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public int solution(int N) {
    List<Integer> digits = covertToListOfDigit(N);
    digits.sort(Comparator.reverseOrder());
    return digits.stream().map(String::valueOf).reduce(String::concat).map(Integer::valueOf)
        .orElse(0);
  }

  private List<Integer> covertToListOfDigit(int n) {
    List<Integer> digitList = new ArrayList<>();
    while (n != 0) {
      digitList.add(n % 10);
      n /= 10;
    }
    return digitList;
  }
}
