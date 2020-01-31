package lintCode;

import java.util.Stack;

public class _1734_Sum_of_Subarray_Minimums {

    /**
     * @param A: an array
     * @return: the sum of subarray minimums
     */
    public static int sumSubarrayMins(int[] A) {
        // Write your code here.
        Stack<Integer> s = new Stack<>();
        int n = A.length, res = 0, mod = (int)1e9 + 7;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? 0 : A[i])) {
                int j = s.pop();
                int k = s.isEmpty() ? -1 : s.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(a));
    }

}
