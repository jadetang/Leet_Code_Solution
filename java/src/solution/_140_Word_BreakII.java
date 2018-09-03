package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jade on 2017/7/2 下午5:56
 */
public class _140_Word_BreakII {


  //这个会超时
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new LinkedList<>();
    List<String> acc = new LinkedList<>();
    Set<String> set = new HashSet<>(wordDict);
    backtrack(result, acc, s, set, 0);
    return result;
  }

  private void backtrack(List<String> res, List<String> acc, String s, Set<String> dict,
      int start) {
    if (start == s.length()) {
      if (!acc.isEmpty()) {
        String str = acc.stream().reduce((s1, s2) -> s1 + " " + s2).get();
        res.add(str);
      }
    } else {
      for (int i = start; i < s.length(); i++) {
        String temp = s.substring(start, i + 1);
        if (dict.contains(temp)) {
          acc.add(temp);
          backtrack(res, acc, s, dict, i + 1);
          acc.remove(acc.size() - 1);
        }
      }
    }
  }


  public ArrayList<String> wordBreak(String s, Set<String> dict) {
    // Note: The Solution object is instantiated only once and is reused by each test case.
    Map<String, ArrayList<String>> map = new HashMap<>();
    return wordBreakHelper(s, dict, map);
  }

  public ArrayList<String> wordBreakHelper(String s, Set<String> dict,
      Map<String, ArrayList<String>> memo) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    ArrayList<String> result = new ArrayList<>();
    int n = s.length();
    if (n <= 0) {
      return result;
    }
    for (int len = 1; len <= n; ++len) {
      String prefix = s.substring(0, len);
      if (dict.contains(prefix)) {

        if (len == n) {
          result.add(prefix);
        } else {
          String sufix = s.substring(len);
          // System.out.println("subfix:"+subfix+" "+prefix);
          ArrayList<String> tmp = wordBreakHelper(sufix, dict, memo);
          for (String item : tmp) {
            item = prefix + " " + item;
            result.add(item);
          }
        }
      }
    }
    memo.put(s, result);
    return result;
  }


}
