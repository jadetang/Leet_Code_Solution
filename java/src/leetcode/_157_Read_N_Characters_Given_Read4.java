package leetcode;

public class _157_Read_N_Characters_Given_Read4 {

    int read4(char[] buf) {
        return -1;
    }

    public int read2(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        char[] buffer = new char[4];
        int offset = 0;
        while (offset < n) {
            int r = read4(buffer);
            if (r == 0) {
                break;
            }
            r = Math.min(r, n - offset);
            for (int i = 0; i < r; i++) {
                buf[offset++] = buffer[i];
            }
        }
        return offset;
    }

}
