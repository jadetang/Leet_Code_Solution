package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import util.Assert;


// o(n!)
// o(n)
public class _996_Number_of_Squareful_Arrays {

    int ans = 0;

    int n;

    List<Integer> path = new ArrayList<>();

    boolean[] used;

    int[] a;

    public int numSquarefulPerms(int[] a) {
        Arrays.sort(a);
        n = a.length;
        used = new boolean[n];
        this.a = a;
        dfs();
        return ans;
    }

    private void dfs() {
        if (path.size() == n) {
            ans++;
        }else {
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && a[i] == a[i - 1] && !used[i - 1]) {
                    continue;
                }
                int current = a[i];
                if (path.size() == 0 || squareful(current + path.get(path.size() -1))) {
                    path.add(a[i]);
                    used[i] = true;
                    dfs();
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean squareful(int n) {
        int s = (int) Math.sqrt(n);
        return n == s * s;
    }

    @Test
    public void test() {
        _996_Number_of_Squareful_Arrays q = new _996_Number_of_Squareful_Arrays();
        int[] arrar = new int[] {1,17,8};
        q.numSquarefulPerms(arrar);
        Assert.assertEqual(2, q.ans);
    }

    @Test
    public void test2() {
        _996_Number_of_Squareful_Arrays q = new _996_Number_of_Squareful_Arrays();
        int[] arrar = new int[] {2,2,2};
        q.numSquarefulPerms(arrar);
        Assert.assertEqual(1, q.ans);
    }

    @Test
    public void test3() {
        _996_Number_of_Squareful_Arrays q = new _996_Number_of_Squareful_Arrays();
        int[] arrar = new int[] {0,0,0,1,1,1};
        q.numSquarefulPerms(arrar);
        Assert.assertEqual(4, q.ans);
    }

}
