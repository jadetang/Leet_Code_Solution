package solution;

public class _387_First_Unique_Character_in_a_String {


  public int firstUniqChar(String s) {
    int[] dict = new int[26];
    for (char c : s.toCharArray()) {
      dict[c - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (dict[c - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }

}
