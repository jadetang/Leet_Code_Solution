/*
package other;

import java.util.LinkedList;
import java.util.Queue;

*/
/**
 * @author jade on 2017/6/22 下午1:23
 *//*

public class MaxCocurrentUser {


    public static void main(String[] args) {
        int[][] users = {{1,3}, {3,4}, {1,2}, {111111,555555},{1,3}};
        quickSort(users, 0, users.length-1);
        int maxUsers = Integer.MIN_VALUE;
        Queue usersStack = new LinkedList();
        usersStack.add(users[0]);

        while (!usersStack.isEmpty()) {
            for(int i=1;i usersStack.peek()[1]) {
                maxUsers = Math.max(maxUsers, usersStack.size());
                usersStack.poll();
            }
            usersStack.add(users[i]);
        }
        maxUsers= Math.max(maxUsers, usersStack.size());
        break;
    }
        System.out.println(maxUsers);
}

    static void quickSort(int [][]users, int start, int end) {
        if(!(end>start))
            return;
        int pIndex = partitionArr(users, start, end);

        quickSort(users, start, pIndex-1);
        quickSort(users, pIndex+1, end);
    }

    static int partitionArr(int [][]users, int start, int end) {

        int pivot = users[end][0];
        int pLogout=users[end][1];
        int partition= start;

        for(int i=start; i<end-1;i++) {
            if(users[i][0] <pivot || (users[i][0] ==pivot &&
                users[i][1] <pLogout)) {
                swap(users, i, partition);
                partition++;
            }
        }
        swap(users, partition, end);
        return partition++;
    }
    static void swap(int[][] users, int from, int to) {
        int[] tmp = users[from];
        users[from] = users[to];
        users[to] =tmp;
    }
}
*/
