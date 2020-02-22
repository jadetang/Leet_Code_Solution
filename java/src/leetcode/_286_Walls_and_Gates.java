package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class _286_Walls_and_Gates {

    @Test
    public void test() {
        _286_Walls_and_Gates q = new _286_Walls_and_Gates();
        int max = Integer.MAX_VALUE;
        int[][] rooms = new int[][]{{max, -1, 0, max}, {max, max, max, -1}, {max, -1, max, -1}, {0, -1, max, max}};
        q.wallsAndGates(rooms);
        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }

    private void wallsAndGates(int[][] rooms) {
        int[] directions = new int[] {1, 0, -1, 0, 1};
        int max = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nexti = current[0] + directions[i];
                int nextj = current[1] + directions[i + 1];
                if (nexti < 0 || nexti >= rooms.length || nextj < 0 || nextj >= rooms[0].length) {
                    continue;
                }
                if (rooms[nexti][nextj] == -1) {
                    continue;
                }
                if (rooms[nexti][nextj] == max) {
                    queue.offer(new int[] {nexti, nextj});
                    rooms[nexti][nextj] = rooms[current[0]][current[1]] + 1;
                }
            }
        }
    }


}
