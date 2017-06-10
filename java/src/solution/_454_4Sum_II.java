package solution;

import level.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanguan.tangsicheng on 2016/11/23 下午5:02
 */
public class _454_4Sum_II implements Medium {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int length = A.length;
        for (int i= 0 ; i<length ; i++) {
            for (int j=0; j<length ; j++) {
                map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
                map2.put(C[i]+D[j],map2.getOrDefault(C[i]+D[j],0)+1);
            }
        }
        int result = 0;
        for(Integer i: map1.keySet()){
            result += map1.get(i)* map2.getOrDefault(-i,0);
        }
        return result;
    }
}
