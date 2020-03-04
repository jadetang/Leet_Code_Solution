package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class _340_Longest_Substring_with_At_Most_K_Distinct_Characters {

    @Test
    public void test() {
        _340_Longest_Substring_with_At_Most_K_Distinct_Characters q = new _340_Longest_Substring_with_At_Most_K_Distinct_Characters();
        Assert.assertEquals(3, q.lengthOfLongestSubstringKDistinct("eceba", 2));
        Assert.assertEquals(2, q.lengthOfLongestSubstringKDistinct("aa", 1));
        Assert.assertEquals(3, q.lengthOfLongestSubstringKDistinct("abcedef", 2));
        Assert.assertEquals(1, q.lengthOfLongestSubstringKDistinct("abc", 1));
        Assert.assertEquals(0, q.lengthOfLongestSubstringKDistinct("", 1));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= k) {
                ans = Math.max(ans, i - j + 1);
            }
            while (map.size() > k) {
                c = s.charAt(j);
                j++;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return ans;
    }

}
