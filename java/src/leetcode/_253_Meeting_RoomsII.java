package leetcode;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import util.Assert;

public class _253_Meeting_RoomsII {

    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] interval : intervals) {
            treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
            treeMap.put(interval[1], treeMap.getOrDefault(interval[1], 0) - 1);
        }
        int ans = 0;
        int sum = 0;
        for (int value : treeMap.values()) {
            sum += value;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    @Test
    public void test() {
        _253_Meeting_RoomsII q = new _253_Meeting_RoomsII();
        int[][] intervals = new int[][]{{0, 30},{5, 10},{15, 20}};
        Assert.assertEqual(2, q.minMeetingRooms(intervals));
    }
}
