package company.booking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/7/10 下午1:28
 */
public class SmartSubString {

    public static List<String> subString(String originStr, int length) {

        String[] str = originStr.split(" ");
        int[][] dp = new int[str.length][length + 1];
        boolean[][] used = new boolean[str.length][length + 1];
        for (int i = 0; i <= length; i++) {
            if (i >= str[0].length()) {
                dp[0][i] = str[0].length();
                used[0][i] = true;
            }
        }
        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j <= length; j++) {
                int currentLength = str[i].length();
                if (currentLength > j) {
                    dp[i][j] = dp[i - 1][j];
                    used[i][j] = false;
                } else {
                    int i1 = dp[i - 1][j];
                    int i2 = dp[i - 1][j - currentLength] + currentLength;
                    if (i1 > i2) {
                        dp[i][j] = i1;
                        used[i][j] = false;
                    } else {
                        dp[i][j] = i2;
                        used[i][j] = true;
                    }

                }

            }

        }

        int max = Integer.MIN_VALUE;
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 1; j <= length; j++) {
                if (dp[i][j] > max) {
                    startI = i;
                    startJ = j;
                    max = dp[i][j];
                }
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = startI; i >= 0; i--) {
            if (used[i][startJ]) {
                res.add(str[i]);
                startJ -= str[i].length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "Featuring stylish rooms and moorings for recreation boats Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam";
        //String s = "Featuring stylish rooms and moorings for";
        // String s = "Featuring stylish rooms";
        //String s = "abc cd dd";
        System.out.println(subString(s, 30));
    }

}
