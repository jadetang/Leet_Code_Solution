package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * DFS 遍历
 *
 * @author jade on 2017/7/1 上午11:57
 */
public class _17_Letter_Combinations_of_a_Phone_Number {

  private static Map<Character, List<Character>> keyBoard = new HashMap<>();

  static {
    keyBoard.put('2', Arrays.asList('a', 'b', 'c'));
    keyBoard.put('3', Arrays.asList('d', 'e', 'f'));
    keyBoard.put('4', Arrays.asList('g', 'h', 'i'));
    keyBoard.put('5', Arrays.asList('j', 'k', 'l'));
    keyBoard.put('6', Arrays.asList('m', 'n', 'o'));
    keyBoard.put('7', Arrays.asList('p', 'q', 'r', 's'));
    keyBoard.put('8', Arrays.asList('t', 'u', 'v'));
    keyBoard.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digit) {
    if (digit == null || digit.length() == 0) {
      return Collections.emptyList();
    }
    List<String> result = new LinkedList<>();
    dfs(result, new StringBuilder(), 0, digit);
    return result;
  }

  private void dfs(List<String> result, StringBuilder stringBuilder, int level, String digit) {
    if (level == digit.length()) {
      result.add(stringBuilder.toString());
    } else {
      for (char c : keyBoard.get(digit.charAt(level))) {
        dfs(result, new StringBuilder(stringBuilder.toString()).append(c), level + 1, digit);
      }
    }
  }

}
