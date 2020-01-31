package lintCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1308_Factor_Combinations {

    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> ans = new HashSet<>();
        dfs(ans, new ArrayList<>(), n, n);
        return new ArrayList<>(ans);
        // write your code here
    }

    private void dfs(Set<List<Integer>> ans, ArrayList<Integer> acc, int n, int remain) {
        System.out.println(acc + ":" + remain);
        if (remain == 1) {
            ans.add(new ArrayList<>(acc));
        }
        for (int i = 2; i * i <= n && i <= remain; i++) {
            if (remain % i == 0) {
                acc.add(i);
                dfs(ans, acc, n, remain / i);
                acc.remove(acc.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _1308_Factor_Combinations q = new _1308_Factor_Combinations();
        System.out.println(q.getFactors(32));
    }

}
