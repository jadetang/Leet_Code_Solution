package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午5:02
 */
public class _139_Word_Break {

    //这个超时了
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return backtrack(s, set, 0, s.length() - 1);
    }

    private boolean backtrack(String s, Set<String> set, int start, int end) {
        if (start > end) {
            return true;
        } else {
            for (int i = start; i <= end; i++) {
                String temp = s.substring(start, i + 1);
                if (set.contains(temp) && backtrack(s, set, i + 1, end)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean wordBreakDp(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        //dp 表示 s 以 i-1 结尾的字符子串能 word break
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        _139_Word_Break q = new _139_Word_Break();
        List<String> dict = Arrays.asList("leet", "code", "good");
        System.out.println(q.wordBreak("leetcodegood", dict));
        System.out.println(q.wordBreakDp("leetcodegood", dict));
    }

}
