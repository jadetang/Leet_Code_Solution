package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/28 下午7:51
 */
public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    public int longestSubstring(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int[] hash = hash(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] < k) {
                sb.append(s.charAt(i)).append("|");
            }
        }
        if (sb.length() == 0) {
            return s.length();
        } else {
            String regx = sb.substring(0, sb.length() - 1);
            String[] subStrings = s.split(regx);
            int max = 0;
            for (String subString :
                    subStrings) {
                max = Math.max(max,longestSubstring(subString,k));

            }
            return max;
        }
    }

    private int[] hash(String s) {
        int[] hash = new int[26];
        for (Character c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        return hash;
    }

    public static void main(String[] args) {
        _395_Longest_Substring_with_At_Least_K_Repeating_Characters q = new _395_Longest_Substring_with_At_Least_K_Repeating_Characters();
        System.out.println(q.longestSubstring("baaabcb", 3));
    }

}
