package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _750_Number_Of_Corner_Rectangles {

    @Test
    public void test() {
        _750_Number_Of_Corner_Rectangles q = new _750_Number_Of_Corner_Rectangles();
        int[][] grid = new int[][] {{1, 1, 1,}, {1, 1, 1,}, {1, 1, 1,}};
        Assert.assertEqual(9, q.countCornerRectangles(grid));
    }

    public int countCornerRectangles(int[][] grid) {
        if (grid.length <= 1) {
            return 0;
        }
        int radix = grid[0].length;
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = j + 1; k < grid.length; k++) {
                    if (grid[i][j] == 1 && grid[i][k] == 1) {
                        int code = j * radix + k;
                        ans += count.getOrDefault(code, 0);
                        count.put(code, count.getOrDefault(code, 0) + 1);
                    }
                }
            }
        }
        return ans;
    }
}
