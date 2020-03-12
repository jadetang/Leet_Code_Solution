package leetcode;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.Test;

public class _218_Skyline {

    @Test
    public void test() {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        _218_Skyline q = new _218_Skyline();
        List<List<Integer>> ans = q.getSkyline(buildings);
        for (List<Integer> a : ans) {
            System.out.println(a);
        }
    }

    @Test
    public void test2() {
        int[][] buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};
        _218_Skyline q = new _218_Skyline();
        List<List<Integer>> ans = q.getSkyline(buildings);
        for (List<Integer> a : ans) {
            System.out.println(a);
        }
    }

    @Test
    public void test3() {
        int[][] buildings = new int[][]{{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
        _218_Skyline q = new _218_Skyline();
        List<List<Integer>> ans = q.getSkyline(buildings);
        for (List<Integer> a : ans) {
            System.out.println(a);
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> events = new ArrayList<>();
        Map<Event, Event> eventMap = new HashMap<>();
        for (int[] building : buildings) {
            Event enter = new Event(building[0], building[2]);
            Event leave = new Event(building[1], -building[2]);
            events.add(enter);
            events.add(leave);
            eventMap.put(leave, enter);
        }
        Collections.sort(events);
        TreeMap<Integer, Set<Event>> set = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (Event event : events) {
            Set<Event> max = set.isEmpty() ? null : set.lastEntry().getValue();
            System.out.println("process event:" + event + " max one " + max);
            boolean enter = event.height > 0;
            int height = Math.abs(event.height);
            if (enter) {
                if (set.isEmpty() || height > set.lastKey()) {
                    ans.add(List.of(event.x, event.height));
                }
                set.computeIfAbsent(height, k -> new HashSet<>()).add(event);
            } else {
                set.get(height).remove(eventMap.get(event));
                if (set.get(height).isEmpty()) {
                    set.remove(height);
                }
                if (!set.isEmpty()) {
                    if (height > set.lastKey()) {
                        ans.add(List.of(event.x, set.lastKey()));
                    }
                }else {
                    ans.add(List.of(event.x, 0));
                }
            }
        }
        return ans;
    }


    public static class Event implements Comparable<Event> {

        int x;

        int height;

        public Event(int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public int compareTo(Event that) {
            if (this.x == that.x) {
                return that.height - this.height;
            }
            return this.x - that.x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .add("height=" + height)
                    .toString();
        }
    }
}