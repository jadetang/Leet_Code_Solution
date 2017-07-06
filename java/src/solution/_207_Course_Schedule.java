package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/7/3 下午11:04
 */
public class _207_Course_Schedule {


    boolean[] visited;

    boolean[] onStack;

    boolean canFinish;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1){
            return true;
        }
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        canFinish = true;
        List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
        //Arrays.fill(graph,new LinkedList<>());
        for (int i = 0 ; i < graph.length ;i ++){
            graph[i] = new LinkedList<>();
        }
        for ( int i = 0 ; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0 ; i < numCourses ; i++){
            if( !graph[i].isEmpty()  ){
                if (!canFinish){
                    return canFinish;
                }else {
                    if (!visited[i]) {
                        dfs(graph, i);
                    }
                }
            }
        }
        return canFinish;
    }

    private void dfs(List<Integer>[] graph, int start) {
        onStack[start] = true;
        visited[start] = true;
        for ( int i : graph[start]){
            if (onStack[i]){
                canFinish = false; //也许前面已经访问过了，所以先判断是否在栈上
                return;
            }else {
                if (!visited[i]){
                    dfs(graph,i);
                }
            }
        }
        onStack[start] = false;
    }

    public static void main(String[] args) {
        _207_Course_Schedule q = new _207_Course_Schedule();
        int[][] p = new int[][]{{1,0}};
        q.canFinish(2,p);
    }

}