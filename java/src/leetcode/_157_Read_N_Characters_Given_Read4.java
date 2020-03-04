package leetcode;

public class _157_Read_N_Characters_Given_Read4 {

    int read4(char[] buf) {
        return -1;
    }

    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        int readtimes = (n - 1) / 4 + 1;
        char[] buffer = new char[4];
        int offset = 0;
        for (int i = 0; i < readtimes; i++) {
            int r = read4(buffer);
            r = Math.min(r, n - offset);
            if (r <= 0) {
                break;
            }
            offset = copy(buf, buffer, offset, r);
        }
        return offset;
    }

    private int copy(char[] dest, char[] src, int offset, int length) {
        int i = 0;
        for (; i < length; i++) {
            dest[offset + i] = src[i];
        }
        return i;
    }


}
