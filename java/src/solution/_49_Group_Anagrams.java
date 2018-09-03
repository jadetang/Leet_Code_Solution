package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author jade on 2017/7/1 下午7:50
 */
public class _49_Group_Anagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> dict = new HashMap<>();

    for (String s : strs) {
      String orderS = ordered(s);
      if (!dict.containsKey(orderS)) {
        dict.put(orderS, new LinkedList<>());
      }
      dict.get(orderS).add(s);
    }
    List<List<String>> result = new LinkedList<>();
    for (List<String> l : dict.values()) {
      result.add(l);
    }
    return result;
  }

  private String ordered(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }


  //本质上是算一个字符串的 signature
  public static List<List<String>> groupAnagrams2(String[] strs) {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97, 101,
        103};//最多10609个z

    List<List<String>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (String s : strs) {
      int key = 1;
      for (char c : s.toCharArray()) {
        key *= prime[c - 'a'];
      }
      List<String> t;
      if (map.containsKey(key)) {
        t = res.get(map.get(key));
      } else {
        t = new ArrayList<>();
        res.add(t);
        map.put(key, res.size() - 1);
      }
      t.add(s);
    }
    return res;
  }

  public static void main(String[] args) {

  }


}
