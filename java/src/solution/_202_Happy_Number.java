package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sanguan.tangsicheng on 2017/7/3 上午8:47
 */
public class _202_Happy_Number {

    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 1) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    //这个和指针有环一样，快慢指针
    boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) { return true; } else { return false; }
    }


    public boolean isHappy2(int n) {
        Set<Integer> acc = new HashSet<>();
        while ( ( n = happy(n) ) != 1){
            if (acc.contains(n)) {
                return false;
            }else{
                acc.add(n);
            }
        }
        return true;
    }

    int happy(int n){
        int result = 0;
        String  str = String.valueOf(n);
        for ( int i = 0 ; i< str.length() ; i++ ) {
            char c = str.charAt(i);
            result += Math.pow(Integer.valueOf(String.valueOf(c)),2);
        }
        return result;
    }

}
