/*
package company.iress;

*/
/**
 * @author jade on 2017/7/7 上午8:32
 *//*

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String s, String t) {
        // write your code in Java SE 8
        if (s == null || t == null) {
            return "IMPOSSIBLE";
        } else if (s.equals(t)) {
            return "NOTHING";
        } else {
            for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                if ( s.charAt(i) == t.charAt(i)){
                    if ( i == s.length() -1 ){

                    }

                }
            }

        }
    }

    private String replaceOrSwap(String s, String t) {
        int index = -1;
        int notSame = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                notSame++;
                if (notSame == 1) {
                    index = i;
                }
            }
        }
        if (notSame == 2 && index < t.length()) {
            if (s.charAt(index) == t.charAt(index + 1) && t.charAt(index) == s.charAt(index + 1)) {
                return "SWAP" + " " + s.charAt(index) + " " + s.charAt(index + 1);
            } else {
                return "IMPOSSIBLE";
            }
        } else {
            return "IMPOSSIBLE";
        }

    }

    private String delete(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                String sl = s.substring(i + 1, s.length());
                String tl = t.substring(i, t.length());
                if (sl.equals(tl)) {
                    return "DELETE " + s.charAt(i);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return "DELETE " + s.charAt(s.length() - 1);

    }

    private String insert(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                String sl = t.charAt(i) + s.substring(i, s.length());
                String tl = t.substring(i, t.length());
                if (sl.equals(tl)) {
                    return "INSERT " + t.charAt(i);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return "INSERT " + t.charAt(t.length() - 1);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("ABC", "ACB"));
        System.out.println(s.solution("nice", "niece"));
        System.out.println(s.solution("form", "from"));
        System.out.println(s.solution("o", "odd"));
        System.out.println(s.solution("aaaabbbbb", "aaaabbbbbb"));
        System.out.println(s.solution("abc", "ab"));

        System.out.println("abc".substring(2, 4));
    }

}
*/
