package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _784_Letter_Case_Permutation {


  public static void main(String[] args) {
    _784_Letter_Case_Permutation q = new _784_Letter_Case_Permutation();
    System.out.println(q.letterCasePermutation("abc"));
  }

  public List<String> letterCasePermutation(String s) {
    List<StringBuilder> ans = new LinkedList<>();
    ans.add(new StringBuilder());
    for (char c : s.toCharArray()) {
      int n = ans.size();
      if (Character.isLetter(c)) {
        for (int i = 0; i < n; ++i) {
          ans.add(new StringBuilder(ans.get(i)));
          ans.get(i).append(Character.toLowerCase(c));
          ans.get(n + i).append(Character.toUpperCase(c));
        }
      } else {
        for (StringBuilder sb : ans) {
          sb.append(n);
        }
      }
    }
    return ans.stream().map(StringBuilder::toString).collect(Collectors.toList());
  }

}
