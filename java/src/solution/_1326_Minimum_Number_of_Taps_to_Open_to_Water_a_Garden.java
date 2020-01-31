package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden {

    public static void main(String[] args) {
        _1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden q = new _1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden();
        int n = 35;
        int[] r =  new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2};
        System.out.println(q.minTaps(n,r));
        System.out.println(q.minTaps2(n,r));
    }

    public int minTaps(int n, int[] ranges) {
        PriorityQueue<Integer>[] queue = new PriorityQueue[n + 1];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        for (int i = 0; i < ranges.length; i++) {
            int range = ranges[i];
            if (range != 0) {
                int left = Math.max(-1, i - range);
                int right = Math.min(n + 1, i + range);
                for (int j = left + 1; j < right; j++) {
                    queue[j].offer(right);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (queue[i].isEmpty()) {
                return -1;
            }else {
                int right = queue[i].peek();
                System.out.println(i + ":" + right);
                i = right;
                ans++;
            }
        }
        return ans;
    }

    public int minTaps2(int n, int[] ranges) {
        //form intial list of intervals
        List<int[]> intervals = new ArrayList();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0)
                continue;
            int l = i - ranges[i], r = i + ranges[i];
            intervals.add(new int[] {l, r});
        }
        //sort intervals based on the left coordinate
        Comparator<int[]> comp = (a1, a2) -> a1[0] - a2[0];
        Collections.sort(intervals, comp);

        //checking how exactly we can merge intervals
        int l = 0, r = 0, res = 0, i = 0;
        while (l < n && i <= intervals.size()) {
            //getting the interval which ends the fatherst to the right
            while (i < intervals.size() && intervals.get(i)[0] <= l) {
                r = Math.max(r, intervals.get(i)[1]);
                ++i;
            }
            //if we can't find the right position that extends our current section - it means that there is a
            //gap and some interval of the pitch is not covered. Thus solution is not posible
            if (l >= r)
                return -1;
            //if we reach here means we found section that covers next piece of the pitch, so
            //make our right coordiate as a left for next searches, also increment count of solutions - we
            //picked just one from the list of intervals
            ++res;
            l = r;
        }
        return res;
    }

}
