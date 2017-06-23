package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author sanguan.tangsicheng on 2017/6/15 下午6:59
 */
public class LargetSubsetAreFibonacci {


    public List<Integer> fibonacciSubset(int[] array){

        Arrays.sort(array);

        int max = array[array.length -1 ];

        Set<Integer> set = new HashSet<>();

        int a = 0;

        int b = 1;

        set.add(a);

       // set.add(b);

        while ( b <= max){
            set.add(b);
            int temp = a+b;
            a = b;
            b = temp;
        }
        List<Integer> list = new LinkedList<>();
        for (int i : array){
            if (set.contains(i)){
                list.add(i);
            }
        }
        return list;

    }
}
