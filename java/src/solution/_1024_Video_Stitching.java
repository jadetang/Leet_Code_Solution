package solution;

public class _1024_Video_Stitching {

    public int videoStitching(int[][] clips, int t) {
        int l = 0;
        int r = 0;
        int i = 0;
        int ans = 0;
        for (; i < clips.length && r < t; ) {
            while (i < clips.length && clips[i][0] <= l) {
                r = Math.max(clips[i][1], r);
                i++;
            }
            if (l == r) {
                return -1;
            }
            l = r;
            ans++;
        }
        return r >= t ? ans : -1;
    }


    public int videoStitching2(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        //dp[i] stores  eding time of the activity that start before or at ithe activity and has latest ending time.
        for (int[] clip : clips) {
            if (clip[0] <= T) {
                dp[clip[0]] = Math.max(dp[clip[0]], clip[1]);
            }
        }

        for (int i = 1; i <= T; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }

        int i = 0;
        int count = 0;
        while (i < T) {
            if (dp[i] == i) {
                break;
            }
            count += 1;
            i = dp[i];
        }
        return i >= T ? count : -1;
    }

    public static void main(String[] args) {
        _1024_Video_Stitching q = new _1024_Video_Stitching();
        int[][] clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(q.videoStitching2(clips, 12));
        int[][] clips2 = new int[][]{{0, 2}, {4, 6}};
        System.out.println(q.videoStitching2(clips2, 7));
    }
}
