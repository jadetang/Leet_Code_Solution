package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class _1061_Lexicographically_Smallest_Equivalent_String {

    @Test
    public void test() {
        assertEquals("makkek", smallestEquivalentString("parker", "morris", "parser"));
    }

    public String smallestEquivalentString(String a, String b, String s) {
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < a.length(); i++) {
            uf.union(a.charAt(i) - 'a', b.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = 'a' + uf.find(s.charAt(i) - 'a');
            sb.append((char)c);
        }
        return sb.toString();
    }

    public static class UnionFind {

        int[] array;

        public UnionFind(int n) {
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }
        }

        public int find(int n) {
            while (n != array[n]) {
                array[n] = array[array[n]];
                n = array[n];
            }
            return n;
        }

        public void union(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti < rootj) {
                array[rootj] = rooti;
            } else if (rooti > rootj){
                array[rooti] = rootj;
            }
        }
    }
}
