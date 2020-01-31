package solution;

import java.util.HashSet;
import java.util.Set;

public class _1319_Number_of_Operations_to_Make_Network_Connected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DSU d = new DSU(n);
        for (int[] c : connections) {
            d.connect(c[0], c[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <n; i++) {
            set.add(d.find(i));
        }
        return set.size() - 1;

    }


    public static class DSU {

        int[] array;

        public DSU(int n) {
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }
        }

        public void connect(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti != rootj) {
                array[rootj] = rooti;
            }
        }

        public int find(int i) {
            while (i != array[i]) {
                i = array[i];
            }
            return i;
        }
    }

}
