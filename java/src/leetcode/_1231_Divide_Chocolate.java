package leetcode;

import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class _1231_Divide_Chocolate {


    @Test
    public void test() {
        _1231_Divide_Chocolate q = new _1231_Divide_Chocolate();
        int[] sweetness = new int[] {1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(6, q.maximizeSweetness(sweetness, 5));
    }

    public int maximizeSweetness(int[] sweetness, int k) {
        int smallest = IntStream.of(sweetness).min().getAsInt();
        int sum = IntStream.of(sweetness).sum();
        if (sweetness.length == k + 1) {
            return smallest;
        }
        int l = smallest;
        int r = sum;
        while (l < r ) {
            int mid = l + (r - l) / 2;
            int cut = 0;
            int rollSum = 0;
            for (int i : sweetness) {
                rollSum += i;
                if (rollSum >= mid) {
                    rollSum = 0;
                    cut++;
                }
                if (cut > k) {
                    break;
                }
            }
            if ( cut > k) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l - 1;
    }

}
