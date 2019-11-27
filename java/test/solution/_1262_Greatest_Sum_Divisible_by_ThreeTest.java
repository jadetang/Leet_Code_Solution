package solution;

import static org.junit.Assert.*;

import org.junit.Test;

public class _1262_Greatest_Sum_Divisible_by_ThreeTest {

    @Test
    public void maxSumDivThree() {
        int[] array = new int[]{2,19,6,16,5,10,7,4,11,6};
        _1262_Greatest_Sum_Divisible_by_Three q = new _1262_Greatest_Sum_Divisible_by_Three();
        assertEquals(84, q.maxSumDivThree(array));
    }
}