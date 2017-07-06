package solution;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(sb.toString());
        if (sb.length() == 0) {
            return s.length();
        } else {
            String regx = sb.substring(0, sb.length() - 1);
            String[] subStrings = s.split(regx);
            int max = 0;
            for (String subString :
                subStrings) {
                max = Math.max(max, longestSubstring(subString, k));

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

    public int longestSubstring2(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> hash = hashMap(s);
        int l = 0;
        int r = s.length() - 1;
        int max = 0;
        while (l < r) {
           // System.out.println(s.substring(l,r+1));
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (hash.get(left) < k) {
                l++;
                int c = hash.get(left);
                if (c == 1) {
                    hash.remove(left);
                } else {
                    hash.put(left, c - 1);
                }
            } else if (hash.get(right) < k) {
                r--;
                int c = hash.get(right);
                if (c == 1) {
                    hash.remove(right);
                } else {
                    hash.put(right, c - 1);
                }

            } else {
                if (isValid(hash, k)) {
                    return r-l+1;
                }
                int index = -1;
                for (int i = l ; i<=r ;i++){
                    if (hash.get(s.charAt(i)) < k ){
                        index = i;
                    }
                }
                String leftstr = s.substring(l,index);
                String rightstr = s.substring(index+1,r+1);
                return Math.max(longestSubstring2(leftstr,k),longestSubstring2(rightstr,k));
            }
        }
        return max;
    }

    private boolean isValid(Map<Character, Integer> hash, int k) {
        return hash.values().stream().allMatch(i -> i >= k);
    }

    private Map<Character, Integer> hashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        _395_Longest_Substring_with_At_Least_K_Repeating_Characters q
            = new _395_Longest_Substring_with_At_Least_K_Repeating_Characters();
        //  System.out.println(q.longestSubstring("baaabc", 3));
        System.out.println(q.longestSubstring2("aacbbbdc", 2));
    }

}
