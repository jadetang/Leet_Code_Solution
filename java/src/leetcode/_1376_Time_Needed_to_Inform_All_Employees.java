package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.Test;
import util.Assert;

public class _1376_Time_Needed_to_Inform_All_Employees {

    @Test
    public void test() {
        int n = 15;
        int headId = 0;
        int[] manager = new int[] {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = new int[] {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        _1376_Time_Needed_to_Inform_All_Employees q = new _1376_Time_Needed_to_Inform_All_Employees();
        Assert.assertEqual(3, q.numOfMinutes(n, headId, manager, informTime));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
        }
        return numOfMinutes2(headID, map, informTime);
    }

    private int numOfMinutes2(int manager, Map<Integer, List<Integer>> map, int[] informTime) {
        int subReportTime = 0;
        for (Integer report : map.getOrDefault(manager, Collections.emptyList())) {
            subReportTime = Math.max(subReportTime, numOfMinutes2(report, map, informTime));
        }
        return informTime[manager] + subReportTime;
    }
}
