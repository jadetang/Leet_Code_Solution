package solution;

import java.util.Random;

/**
 * @author sanguan.tangsicheng on 16/7/13 下午4:00
 */
public class _374_Guess_Number_Higher_Or_Lower {

    public int guessNumber(int n) {
        int L = 1,R = n;
        while(L <= R){ int mid = L + ((R - L) >> 1);
            int res = guess(mid);
            if(res == 0) return mid;
            else if(res == 1)  L = mid + 1;
            else R = mid - 1;
        }
        return L;
    }

    private int guess(int n){
        return -1;
    }


}
