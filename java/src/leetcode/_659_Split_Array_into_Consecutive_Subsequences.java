/*
package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class _659_Split_Array_into_Consecutive_Subsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        Map<Integer, Integer> subsequence = new HashMap<>();
        for (int i : nums) {
            if (count.get(i - 1) != null) {
                count.put(i, count.getOrDefault(i, 0) + 1);
                count.put(i - 1, count.get(i - 1) - 1);
                if (count.get(i - 1) == 0) {
                    count.remove(i - 1);
                }
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    count.remove(i);
                }
            }else {
                if ()
            }
        }
    }
}
*/
