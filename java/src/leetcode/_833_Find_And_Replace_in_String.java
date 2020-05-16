package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;
import util.Assert;

public class _833_Find_And_Replace_in_String {

    @Test
    public void test() {
        String S = "abcd";
        int[] indexes = new int[]{0,2};
        String[] sources = new String[]{"a","cd"};
        String[] targets = new String[]{"eee","ffff"};
        _833_Find_And_Replace_in_String q = new _833_Find_And_Replace_in_String();
        Assert.assertEqual("eeebffff", q.findReplaceString(S, indexes, sources, targets));
    }

    @Test
    public void test2() {
        String S = "abcd";
        int[] indexes = new int[]{0,2};
        String[] sources = new String[]{"ab","ec"};
        String[] targets = new String[]{"eee","ffff"};
        _833_Find_And_Replace_in_String q = new _833_Find_And_Replace_in_String();
        Assert.assertEqual("eeecd", q.findReplaceString(S, indexes, sources, targets));
    }

    public static class Operation {
        String source;
        String target;
        int index;

        public Operation(String source, String target, int index) {
            this.source = source;
            this.target = target;
            this.index = index;
        }
    }

    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Operation[] operations = new Operation[indexes.length];
        for (int i = 0; i < sources.length; i++) {
            operations[i] = new Operation(sources[i], targets[i], indexes[i]);
        }
        Arrays.sort(operations, Comparator.comparingInt(o -> o.index));
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < operations.length && i == operations[j].index) {
                String source = operations[j].source;
                int sourceLength = source.length();
                if (s.substring(i, Math.min(s.length(), i + sourceLength)).equals(source)) {
                    sb.append(operations[j].target);
                    i += sourceLength - 1;
                }else {
                    sb.append(s.charAt(i));
                }
                j++;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
