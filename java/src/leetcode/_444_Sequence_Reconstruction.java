package leetcode;

import java.util.List;
import org.junit.Test;
import util.Assert;

public class _444_Sequence_Reconstruction {

  @Test
  public void test() {
    _444_Sequence_Reconstruction q = new _444_Sequence_Reconstruction();
    List<List<Integer>> seqs = List.of(List.of(5, 2, 6, 3), List.of(4, 1, 5, 2));
    int[] org = new int[]{4, 1, 5, 2, 6, 3};
    Assert.assertTrue(q.sequenceReconstruction(org, seqs));
  }

  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    int[] numberToIndex = new int[org.length + 1];
    numberToIndex[0] = -1;
    for (int i = 0; i < org.length; i++) {
      numberToIndex[org[i]] = i;
    }
    for (List<Integer> seq : seqs) {
      Integer pre = null;
      for (Integer current : seq) {
        if (pre == null) {
          pre = current;
        } else {
          int preIndex = numberToIndex[pre];
          int curIndex = numberToIndex[current];
          if (preIndex >= curIndex) {
            return false;
          }
          pre = current;
        }
      }
    }
    return true;
  }
}
