package leetcode;

/**
 * @author jade on 2016/11/20 下午6:06
 */
public class _424_Longest_Repeating_Character_Replacement {

  public static void main(String[] args) {
    _424_Longest_Repeating_Character_Replacement q = new _424_Longest_Repeating_Character_Replacement();
    System.out.println(q.characterReplacement("ACBABBA", 1));
    System.out.println(q.characterReplacement("BBBBBBA", 1));
    System.out.println(q.characterReplacement("ABAA", 0));
    System.out.println(q.characterReplacement("ABBB", 1));
  }

  public int characterReplacement(String s, int k) {
    int[] hash = new int[26];
    int left = 0;
    int maxSameChar = Integer.MIN_VALUE;
    int maxLength = Integer.MIN_VALUE;
    for (int right = 0; right < s.length(); right++) {
      maxSameChar = Math.max(maxSameChar, ++hash[s.charAt(right) - 'A']);
      while (right - left + 1 - maxSameChar > k) {
        hash[s.charAt(left) - 'A']--;
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }
}
