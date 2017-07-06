package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * @author sanguan.tangsicheng on 2016/11/27 上午10:22
 */
public class _44_Wildcard_Matching {


    private Map<String, String> match = new HashMap<>();

    private Map<String, String> notMatch = new HashMap<>();


    public boolean isMatch(String s, String p) {

        if (match.containsKey(s) && match.get(s).equals(p)) {
            return true;
        }

        if (notMatch.containsKey(s) && notMatch.get(s).equals(p)) {
            return false;
        }


        int pos = 0;
        if (pos < s.length() && pos < p.length() && (
                s.charAt(pos) == p.charAt(pos) || p.charAt(pos) == '?'
        )) {
            boolean match = isMatch(s.substring(pos + 1), p.substring(pos + 1));
            if (match) {
                this.match.put(s, p);
            } else {
                this.notMatch.put(s, p);
            }
            return match;
        }
        if (pos == p.length()) {
            boolean match = pos == s.length();
            if (match) {
                this.match.put(s, p);
            } else {
                this.notMatch.put(s, p);
            }
            return match;
        } else {
            if (p.charAt(pos) == '*') {
                if (isMatch(s.substring(pos), p.substring(pos + 1)) || (pos < s.length() && isMatch(s.substring(pos + 1), p.substring(pos)))) {
                    this.match.put(s, p);
                    return true;
                }
            }
            this.notMatch.put(s, p);
            return false;
        }
    }

    public static void main(String[] args) {
        _44_Wildcard_Matching q = new _44_Wildcard_Matching();

        String s = "ababaabaabbbbbabbbaaababbaabbbbbaaabaabababaaaabbabbbbabbaaaaaaaaabaababbaabaaababaababaabbabbbbbabababbabaabbbaababbbababaaabbbbbbbbbabaababaaabababbbbabbaabaaabbbababbbbbbbbabaaaabbabbbbabbaaabbbbababab";
        String w = "ab**bbb*a*ab*bb*aa*a***ab*b**b***bba****b*aaabaa**bb*ab*a***abb****bb*a**b*****a*abaa**a****aab**aa**bbb";
        System.out.println(q.isMatch(s, w));
    }
}
