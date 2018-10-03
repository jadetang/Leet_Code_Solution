package other;


import java.util.BitSet;

/**
 *
 */
public class PermutationDetermine {

  public static void main(String[] args) {

  }

  public boolean solution(int[] A) {
    BitSet bitSet = new BitSet();

    for (int i = 0; i < A.length; i++) {
      if (bitSet.get(A[i])) {
        return false;
      } else {
        bitSet.set(A[i]);
      }
    }
    return bitSet.get(1, A.length + 1).cardinality() == A.length;
  }

}
