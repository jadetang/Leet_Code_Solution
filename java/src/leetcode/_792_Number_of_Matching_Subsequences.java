package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import util.Assert;

public class _792_Number_of_Matching_Subsequences {

  @Test
  public void test() {
    _792_Number_of_Matching_Subsequences q = new _792_Number_of_Matching_Subsequences();
    var s = "abcde";
    var words = new String[]{"a", "bb", "acd", "ace"};
    Assert.assertEqual(3, q.numMatchingSubseq(s, words));
  }

  public int numMatchingSubseq(String s, String[] words) {
    var indexList = process(s);
    int ans = 0;
    for (String word : words) {
      if (subSeq(indexList, word)) {
        ans++;
      }
    }
    return ans;
  }

  private boolean subSeq(Map<Character, ArrayList<Integer>> indexList, String word) {
    var largest = -1;
    for (char c : word.toCharArray()) {
      var indexs = indexList.get(c);
      if (indexs == null) {
        return false;
      }
      var index = nextLargest(indexs, largest);
      if (index == indexs.size()) {
        return false;
      }
      largest = indexs.get(index);

    }
    return true;
  }

  private int nextLargest(ArrayList<Integer> indexs, int target) {
    int l = 0;
    int r = indexs.size();
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (indexs.get(mid) > target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  Map<Character, ArrayList<Integer>> process(String s) {
    Map<Character, ArrayList<Integer>> maps = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      maps.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
    }
    return maps;
  }
}
