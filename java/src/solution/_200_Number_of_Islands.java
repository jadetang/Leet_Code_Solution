package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sanguan.tangsicheng on 2017/7/3 上午8:08
 */
public class _200_Number_of_Islands {


    boolean[][] visited;

    int row;

    int col;

    char[][] grid;

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        this.visited = new boolean[grid.length][grid[0].length];
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        int res =0;
        for( int i= 0 ; i< row;i++){
            for( int j= 0 ; j < col; j++){
                if( !visited[i][j] && grid[i][j] == '1'){
                    bfs(i,j);
                    res++;
                }
            }
        }
        return res;
    }


    private void bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] p = q.poll();
            x = p[0];
            y = p[1];
            if( x<0 || y < 0 || x>=row || y>=col || visited[x][y] || grid[x][y] == '0'){
                continue;
            }else{
                visited[x][y] = true;
                q.offer(new int[]{x+1,y});
                q.offer(new int[]{x-1,y});
                q.offer(new int[]{x,y-1});
                q.offer(new int[]{x,y+1});
            }
        }

    }
}
