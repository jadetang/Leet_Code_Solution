package leetcode;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import util.Assert;

public class _1366_Rank_Teams_by_Votes {

  @Test
  public void test() {
    _1366_Rank_Teams_by_Votes q = new _1366_Rank_Teams_by_Votes();
    Assert.assertEqual("XWYZ", q.rankTeams(new String[]{"WXYZ", "XYZW"}));
  }

  @Test
  public void test2() {
    _1366_Rank_Teams_by_Votes q = new _1366_Rank_Teams_by_Votes();
    Assert.assertEqual("ACB", q.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
  }

  public String rankTeams(String[] votes) {
    Map<Character, Count> maps = new HashMap<>();
    for (String vote : votes) {
      int n = vote.length();
      for (int i = 0; i < n; i++) {
        char c = vote.charAt(i);
        maps.putIfAbsent(c, new Count(c, n));
        Count count = maps.get(c);
        count.score[i]++;
      }
    }
    StringBuilder sb = new StringBuilder();
    maps.values().stream().sorted().forEach(e -> sb.append(e.c));
    return sb.toString();
  }

  public static class Count implements Comparable<Count> {

    int[] score;
    char c;

    public Count(char c, int n) {
      this.c = c;
      this.score = new int[n];
    }

    @Override
    public int compareTo(@NotNull _1366_Rank_Teams_by_Votes.Count o) {
      for (int i = 0; i < score.length; i++) {
        if (this.score[i] == o.score[i]) {
          continue;
        } else {
          return o.score[i] - this.score[i];
        }
      }
      return this.c - o.c;
    }
  }

}
