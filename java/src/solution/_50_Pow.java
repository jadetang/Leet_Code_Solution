package solution;

/**
 *
 * class Solution {
         public:
         double pow(double x, int n) {
         if(n<0){
         x = 1.0/x;
         n = -n;
         }
         int unsigned m = n;
         double tbl[32] = {0};
         double result = 1;
         tbl[0] = x;
         for(int i=1;i<32;i++){
         tbl[i] = tbl[i-1]*tbl[i-1];
         }
         for(int i=0;i<32;i++){
         if( m & (0x1<<i) )
         result *= tbl[i];
         }
         return result;
         }
         };
 * @author sanguan.tangsicheng on 2017/7/1 下午8:03
 */
public class _50_Pow {

    static double myPow(double x, int n) {
        if (n < 0) { return 1 / x * myPow(1 / x, -(n + 1)); }
        if (n == 0) { return 1; }
        if (n == 2) { return x * x; }
        if (n % 2 == 0) { return myPow(myPow(x, n / 2), 2); } else { return x * myPow(myPow(x, n / 2), 2); }
    }

    double myPow2(double x, int n) {
        if (n == 0) { return 1; }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);
    }

    double myPow3(double x, int n) {
        if (n == 0) { return 1; }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) { ans *= x; }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 0));
    }
}
