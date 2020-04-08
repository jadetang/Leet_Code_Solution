package leetcode;

import java.util.Arrays;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Test;
import tag.Array;

public class _825_Friends_Of_Appropriate_Ages {

  @Test
  public void test() {
    _825_Friends_Of_Appropriate_Ages q = new _825_Friends_Of_Appropriate_Ages();
    int[] ages = new int[] {16, 16, 16, 16, 18};
    Assert.assertEquals(0, q.lowerBoundInclusive(ages, 16));
    Assert.assertEquals(0, q.lowerBoundInclusive(ages, 0));
    Assert.assertEquals(4, q.upperBoundExeclusive(ages, 17));
    Assert.assertEquals(4, q.upperBoundExeclusive(ages, 17));
  }

  @Test
  public void test2() {
    _825_Friends_Of_Appropriate_Ages q = new _825_Friends_Of_Appropriate_Ages();
    int[] ages = new int[] {20,30,100,110,120};
    Assert.assertEquals(3, q.numFriendRequests(ages));
  }

  public int numFriendRequests(int[] ages) {
    Arrays.sort(ages);
    int ans = 0;
    for (int i = 0; i < ages.length; i++) {
      int age = ages[i];
      int lowerBound = age / 2 - 7;
      int upperBound = age;
      if (age < 100) {
        upperBound = Math.min(upperBound, 100);
      }
      int lowerBoundIndex = lowerBoundInclusive(ages, lowerBound);
      int upperBoundIndex = lowerBoundInclusive(ages, upperBound);
      if (lowerBoundIndex > upperBoundIndex) {
        continue;
      }
      if (lowerBoundIndex <= i && upperBoundIndex >= i) {
        ans += upperBoundIndex - lowerBoundIndex;
      }else {
        ans += upperBoundIndex - lowerBoundIndex + 1;
      }
    }
    return ans;
  }

  int upperBoundExeclusive(int[] ages, int upperBound) {
    int l = 0;
    int r = ages.length - 1;
    while (l < r ) {
      int mid = l + (r - l) / 2;
      if (ages[mid] > upperBound) {
        r = mid;
      }else {
        l = mid + 1;
      }
    }
    return l;
  }

  int lowerBoundInclusive(int[] ages, int lowerBound) {
    int l = 0;
    int r = ages.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (ages[mid] >= lowerBound) {
        r = mid;
      }else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean request(int[] ages, int a, int b) {
    return (ages[b] - 7> 0.5 * ages[a]) && ages[b] <= ages[a] && (ages[b] <= 100
        || ages[a] >= 100);
  }

}
