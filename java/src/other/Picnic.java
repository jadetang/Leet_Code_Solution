package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Pinic porblem: kindergarten is going to hold a picnic event, two students will be grouped together, however, not every
 * student are friends with each other, and only students are knew each other could be grouped as a team. For n students,
 * there m pairs of friends, find out how many different forms of groups can be.
 *
 * @author sanguan.tangsicheng on 2016/11/26 下午12:26
 */
public class Picnic {
    /**
     * @param n    number of student, marked as 0,1,2,... n is even
     * @param pair students are friends,like [0,1] [1,2] [2,3]
     * @return how many different way to group students
     */
    public int picnic(int n, int[][] pair) {
        boolean[] picked = new boolean[n];
        List<List<int[]>> acc = new LinkedList<>();
        backtrack(acc, new ArrayList<>(), picked, 0, pair);
        return acc.size();
    }


    private void backtrack(List<List<int[]>> acc, ArrayList<int[]> tempList, boolean[] picked, int start, int[][] pair) {
        if (tempList.size() == picked.length / 2) {
            acc.add(new LinkedList<>(tempList));
        } else {
            for (int i = start; i < pair.length; i++) {
                if (!picked[pair[i][0]] && !picked[pair[i][1]]) {
                    picked[pair[i][0]] = true;
                    picked[pair[i][1]] = true;
                    tempList.add(pair[i]);
                    backtrack(acc,tempList,picked,i+1,pair);
                    picked[pair[i][0]] = false;
                    picked[pair[i][1]] = false;
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Picnic p = new Picnic();


        int[][] pair = new int[][]{ {0,1}, {1,2} ,{2,3},{3,0},{0,2},{1,3}};
        System.out.println(p.picnic(4,pair)); //should be 2

        int[][] pair2 = new int[][]{ {0,1},{0,2},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4},{3,5},{4,5}};
        System.out.println(p.picnic(6,pair2)); //should be 4

        int[][] pair3 = new int[][]{ {0,1}};
        System.out.println(p.picnic(2,pair3));


    }

}
