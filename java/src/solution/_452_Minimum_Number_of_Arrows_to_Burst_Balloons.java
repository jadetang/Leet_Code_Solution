package solution;

import java.util.Arrays;

/**
 * @author sanguan.tangsicheng on 2016/11/16 上午8:42
 */
public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }else if (points.length == 1) {
            return 1;
        } else {
            Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
            int count = 1;
            int upperBound = points[0][1];
            for (int i = 0; i < points.length - 1; ) {
                while ( i < points.length && points[i][0]<= upperBound ){
                    if (points[i][1] < upperBound){
                        upperBound = points[i][1];
                    }
                    i++;
                }
                if (i == points.length){
                    break;
                }else {
                    count++;
                    upperBound = points[i][1];
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        _452_Minimum_Number_of_Arrows_to_Burst_Balloons q = new _452_Minimum_Number_of_Arrows_to_Burst_Balloons();
        int[][] points = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(q.findMinArrowShots(points));

    }
}
