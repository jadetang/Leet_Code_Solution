package solution;

public class _992_Subarrays_with_K_Different_Integers {

    public int subarraysWithKDistinct(int[] a, int k) {
        return count(a, k) - count(a, k - 1);
    }

    //this method count how many subarray in a which has k or less unique elements.
    private int count(int[] a, int k) {
        int[] count = new int[a.length + 1];
        int distinct = 0;
        int ans = 0;
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (count[a[j]]++ == 0) {
                distinct++;
            }
            while (distinct > k) {
                if (--count[a[i++]] == 0) {
                    distinct--;
                }
            }
            ans += j - i + 1;
        }
        return ans;
    }

}
