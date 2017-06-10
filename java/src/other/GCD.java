package other;

/**
 * @author sanguan.tangsicheng on 2016/12/3 上午11:47
 */
public class GCD {

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd( b % a, a);
        }
    }


    public static void main(String[] args) {
        System.out.println(gcd(1,0));
        System.out.println(gcd(0,1));
        System.out.println(gcd(4,2));
        System.out.println(gcd(2,4));
        System.out.println(gcd(1,4));
        System.out.println(gcd(3,5));
    }

}
