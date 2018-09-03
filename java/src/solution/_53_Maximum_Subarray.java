package solution;

/**
 * this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM
 * P885)
 *
 * the paragraph below was copied from his paper (with a little modifications)
 *
 * algorithm that operates on arrays: it starts at the left end (element A[1]) and scans t through to
 * the right end (element A[n]), keeping track of the maximum sum subvector seen so far. The maximum
 * is initially A[0]. Suppose we've solved the problem for A[1 .. i - 1]; how can we extend that to
 * A[1 .. i]? The maximum sum in the first I elements is either the maximum sum in the first i - 1
 * elements (which we'll call MaxSoFar), or it is that of a subvector that ends in position i (which
 * we'll call MaxEndingHere).
 *
 * MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is larger
 *
 * @author jade on 2017/7/1 下午8:19
 */
public class _53_Maximum_Subarray {

  public int maxSubArray(int[] A) {

    int maxSoFar = A[0];
    int maxEndingHere = A[0];

    for (int i = 1; i < A.length; i++) {
      //如果A[i]是负数，那么 maxEndingHear 就不会更新。如果A[i]是正数，maxEndingHere 是负数，就直接取A[i]
      maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;


  }


}
