package leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class _90_Subsets_II {

    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            dfs(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    @Test
    public void test( ) {
        _90_Subsets_II q = new _90_Subsets_II();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(q.subsetsWithDup(nums));
    }

}
