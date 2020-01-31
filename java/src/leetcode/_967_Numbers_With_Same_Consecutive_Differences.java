package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _967_Numbers_With_Same_Consecutive_Differences {

  public static void main(String[] args) {
    _967_Numbers_With_Same_Consecutive_Differences q = new _967_Numbers_With_Same_Consecutive_Differences();

    int[] result = q.numsSameConsecDiff(2, 1);

    System.out.println(Arrays.toString(result));


  }


  public int[] numsSameConsecDiff(int n, int k) {
    List<Integer> ans = new ArrayList<>();
    List<Integer> acc = new ArrayList<>();
    backtrack(ans, acc, n, k);
    return ans.stream().mapToInt(i -> i).toArray();
  }

  private void backtrack(List<Integer> ans, List<Integer> acc, int n, int k) {
    if (acc.size() == n) {
      ans.add(toInt(acc));
    } else {
      for (int i = 0; i <= 9; i++) {
        if (acc.isEmpty()) {
          if (i != 0 || n == 1) {
            acc.add(i);
            backtrack(ans, acc, n, k);
            acc.remove(acc.size() - 1);
          }
        } else {
          int lastDigit = acc.get(acc.size() - 1);
          if (Math.abs(lastDigit - i) == k) {
            acc.add(i);
            backtrack(ans, acc, n, k);
            acc.remove(acc.size() - 1);
          }
        }
      }
    }
  }


  private int toInt(List<Integer> acc) {
    int res = 0;
    for (int i : acc) {
      res = (res * 10 + i);
    }
    return res;
  }

}
