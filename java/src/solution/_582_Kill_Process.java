package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sanguan.tangsicheng on 2017/6/7 下午11:32
 */
public class _582_Kill_Process {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int[] pidArray = toArray(pid);
        int[] ppidArray = toArray(ppid);
        LinkedList<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while( !queue.isEmpty()){
            int currentPid = queue.poll();
            result.add(currentPid);
            for(Integer p : findChildren(pidArray,ppidArray,currentPid)){
                queue.offer(p);
            }

        }
        return result;
    }

    private int[] toArray(List<Integer> list){
        int[] result = new int[list.size()];
        int i = 0;
        for( Integer n  : list ){
            result[i++] = n;
        }
        return result;
    }


    private List<Integer> findChildren(int[] pid, int[] ppid, int currentPid){
        List<Integer> list = new LinkedList<>();
        for( int i = 0 ; i < ppid.length ; i++){
            if( ppid[i] == currentPid){
                list.add(pid[i]);
            }
        }
        return list;
    }
}
