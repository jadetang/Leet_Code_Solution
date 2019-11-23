package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class _1253_Reconstruct_a_2Row_Binary_Matrix {

  public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    int totalSum = IntStream.of(colsum).sum();
    if (totalSum != upper + lower) {
      return Collections.emptyList();
    }
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    ans.add(new ArrayList<>());
    for (int sum : colsum) {
      if (sum == 0) {
        ans.get(0).add(0);
        ans.get(0).add(0);
      } else if (sum == 2) {
        ans.get(0).add(1);
        ans.get(0).add(1);
        upper--;
        lower--;
      } else if (sum == 1) {
        if (upper > lower) {
          ans.get(0).add(1);
          ans.get(0).add(0);
          upper--;
        } else {
          ans.get(0).add(0);
          ans.get(0).add(1);
          lower--;
        }
      }
    }
    if (upper != 0 || lower != 0) {
      return Collections.emptyList();
    }
    return ans;
  }
}
