package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _1007_Minimum_Domino_Rotations_For_Equal_Row {

    @Test
    public void test() {
        int[] a = new int[]{2,1,2,4,2,2};
        int[] b = new int[]{5,2,6,2,3,2};
        _1007_Minimum_Domino_Rotations_For_Equal_Row q = new _1007_Minimum_Domino_Rotations_For_Equal_Row();
        Assert.assertEquals(2, q.minDominoRotations(a, b));
    }

    @Test
    public void test2() {
        int[] a = new int[]{3,5,1,2,3};
        int[] b = new int[]{3,6,3,3,4};
        _1007_Minimum_Domino_Rotations_For_Equal_Row q = new _1007_Minimum_Domino_Rotations_For_Equal_Row();
        Assert.assertEquals(-1, q.minDominoRotations(a, b));
    }

    public int minDominoRotations(int[] a, int[] b) {
        int[] count = new int[7];
        int n = a.length;
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
            if (a[i] != b[i]) {
                count[b[i]]++;
            }
        }
        int target = 0;
        for (int i = 1; i <= 6; i++) {
            if (count[i] == n) {
                target = i;
                break;
            }
        }
        if (target == 0) {
            return -1;
        }
        int aFlip = 0;
        int bFlip = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i] && a[i] == target) {
                continue;
            }
            if (a[i] == target) {
                aFlip++;
            }else {
                bFlip++;
            }
        }
        return Math.min(aFlip, bFlip);
    }
}
