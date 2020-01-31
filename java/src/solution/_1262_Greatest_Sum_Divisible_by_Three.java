package solution;

public class _1262_Greatest_Sum_Divisible_by_Three {

    public int maxSumDivThree(int[] array) {
        int max0 = 0;
        int max1 = 0;
        int max2 = 0;
        int mod = array[0] % 3;
        if (mod == 0) {
            max0 = array[0];
        } else if (mod == 1) {
            max1 = array[0];
        } else {
            max2 = array[0];
        }
        for (int i = 1; i < array.length; i++) {
            mod = array[i] % 3;
            int tMax0 = 0;
            int tMax1 = 0;
            int tMax2 = 0;
            if (mod == 0) {
                tMax0 = max0 + array[i];
                tMax1 = max1 == 0 ? 0 : max1 + array[i];
                tMax2 = max2 == 0 ? 0 : max2 + array[i];
            } else if (mod == 1) {
                tMax0 = max2 == 0 ? 0 : max2 + array[i];
                tMax1 = max0 + array[i];
                tMax2 = max1 == 0 ? 0 : max1 + array[i];
            } else {
                tMax0 = max1 == 0 ? 0 : max1 + array[i];
                tMax1 = max2 == 0 ? 0 : max2 + array[i];
                tMax2 = max0 + array[i];
            }
            max0 = Math.max(tMax0, max0);
            max1 = Math.max(tMax1, max1);
            max2 = Math.max(tMax2, max2);
        }
        return max0;
    }
}