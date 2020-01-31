package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import util.Assert;

/**
 * This problem is a variation of standard Longest Increasing Subsequence problem. Following is a
 * simple two step process. 1) Sort given pairs in increasing order of first (or smaller) element.
 * 2) Now run a modified LIS process where we compare the second element of already finalized LIS
 * with the first element of new LIS being constructed.
 *
 * @author jade on 2017/8/6 下午9:07
 */
public class _646_Maximum_Length_of_Pair_Chain {

  public static int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
    int[] length = new int[pairs.length];
    Arrays.fill(length, 1);
    for (int i = 1; i < pairs.length; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[i][0] > pairs[j][1]) {
          length[i] = Math.max(length[i], length[j] + 1);
        }
      }
    }
    return IntStream.of(length).max().getAsInt();

  }


  public static void main(String[] args) {
    int[][] pairs = new int[][]{{3, 4}, {2, 3}, {1, 2}};
    int length = findLongestChain(pairs);
    Assert.assertEqual(2, length);
  }
}
