package solution;

public class _1335_Minimum_Difficulty_of_a_Job_Schedule {

    public static void main(String[] args) {
        _1335_Minimum_Difficulty_of_a_Job_Schedule q = new _1335_Minimum_Difficulty_of_a_Job_Schedule();
        int[] jobs = new int[]{6,5,4,3,2,1};
        int d = 3;
        System.out.println(q.minDifficulty(jobs, d));
    }

    int[][] cache;
    public int minDifficulty(int[] jobDifficulty, int d) {
        cache = new int[jobDifficulty.length + 1][d + 1];
        if (d > jobDifficulty.length) {
            return -1;
        }
        return find(jobDifficulty, jobDifficulty.length, d);
    }

    private int find(int[] jobs, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        if (j > i) {
            return 1000000000;
        }
        if (i == 0) {
            return 0;
        }
        if (j == 1) {
            int max = jobs[0];
            for (int k = 0; k < i; k++) {
                max = Math.max(max, jobs[k]);
            }
            cache[i][j] = max;
            return cache[i][j];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k > 0; k--) {
            max = Math.max(max, jobs[k - 1]);
            min = Math.min(min, max + find(jobs, k - 1, j - 1));
        }
        cache[i][j] = min;
        return cache[i][j];
    }

}
