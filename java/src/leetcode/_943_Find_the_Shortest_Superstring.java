package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;
import util.Assert;

public class _943_Find_the_Shortest_Superstring {

    int[][] cost;

    String[] a;

    int bestLength = Integer.MAX_VALUE;

    ArrayList<Integer> bestPath = new ArrayList<>();

    boolean[] used;

    public String shortestSuperstring(String[] a) {
        cost = new int[a.length][a.length];
        for (int [] c : cost) {
            Arrays.fill(c, -1);
        }
        used = new boolean[a.length];
        this.a = a;
        LinkedList<Integer> path = new LinkedList<>();
        dfs(path,0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bestPath.size(); i++) {
            if (i == 0) {
                stringBuilder.append(a[bestPath.get(i)]);
            }else {
                int length = cost(bestPath.get(i -1), bestPath.get(i));
                String nextWord = a[bestPath.get(i)];
                stringBuilder.append(nextWord.substring(nextWord.length() - length));
            }
        }
        return stringBuilder.toString();
    }


    private void dfs(LinkedList<Integer> path, int length) {
        if (length >= bestLength) {
            return;
        }
        if (path.size() == a.length) {
            bestLength = length;
            bestPath = new ArrayList<>(path);
        }else {
            for (int i = 0; i < a.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                if (path.size() == 0) {
                    assert(length == 0);
                    path.add(i);
                    dfs(path, a[i].length());
                }else {
                    Integer last = path.getLast();
                    path.add(i);
                    dfs(path, length + cost(last, i));
                }
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    private int cost(int i, int j) {
        if (cost[i][j] != -1) {
            return cost[i][j];
        }
        String first = a[i];
        String second = a[j];
        cost[i][j] = second.length();
        for (int k = 1; k <= Math.min(first.length(), second.length()); k++) {
            if (first.substring(first.length() - k).equals(second.substring(0,k))) {
                cost[i][j] = second.length() - k;
            }
        }
        return cost[i][j];
    }

    @Test
    public void test() {
        _943_Find_the_Shortest_Superstring q = new _943_Find_the_Shortest_Superstring();
        String[] a = new String[] {"a", "b"};
        Assert.assertEqual("ab", q.shortestSuperstring(a));
    }

    @Test
    public void test2() {
        _943_Find_the_Shortest_Superstring q = new _943_Find_the_Shortest_Superstring();
        String[] a = new String[] {"aa", "ac"};
        Assert.assertEqual("aac", q.shortestSuperstring(a));
    }

    @Test
    public void test3() {
        _943_Find_the_Shortest_Superstring q = new _943_Find_the_Shortest_Superstring();
        String[] a = new String[] {"catg","ctaagt","gcta","ttca","atgcatc"};
        Assert.assertEqual("gctaagttcatgcatc", q.shortestSuperstring(a));
    }
}