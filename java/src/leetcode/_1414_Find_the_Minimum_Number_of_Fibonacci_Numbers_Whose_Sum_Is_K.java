package leetcode;

import java.util.TreeSet;
import org.junit.Test;
import util.Assert;

public class _1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K {

  @Test
  public void test() {
    _1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K q = new _1414_Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K();
    Assert.assertEqual(2, q.findMinFibonacciNumbers(4));
  }

  public int findMinFibonacciNumbers(int k) {
    if (k == 0) {
      return 1;
    }
    TreeSet<Integer> fnumbers = allFNumbers(k);
    int ans = 0;
    while (k != 0) {
      int largest = fnumbers.floor(k);
      k -= largest;
      ans++;
    }
    return ans;
  }

  TreeSet allFNumbers(int k) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    int f1 = 1;
    int f2 = 1;
    while (f2 <= k) {
      treeSet.add(f2);
      int temp = f2;
      f2 = f1 + f2;
      f1 = temp;
    }
    return treeSet;
  }
}
