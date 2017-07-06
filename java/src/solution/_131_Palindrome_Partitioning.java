package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午4:25
 */
public class _131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void backtrack(List<List<String>> list, ArrayList<String> acc, String str, int start) {
        if (start == str.length()) {
            list.add(new LinkedList<>(acc));
        } else {
            for (int i = start; i < str.length(); i++) {
                if (isPalindrome(str, start, i)) {
                    acc.add(str.substring(start, i + 1));
                    backtrack(list, acc, str, i + 1);
                    acc.remove(acc.size() - 1);
                }

            }

        }
    }

    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) { if (s.charAt(low++) != s.charAt(high--)) { return false; } }
        return true;
    }
}
