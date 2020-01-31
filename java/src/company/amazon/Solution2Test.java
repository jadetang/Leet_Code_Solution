package company.amazon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution2Test {

  Solution2 solution2 = new Solution2();

  @Test
  public void solution() {
    System.out.println(Integer.toBinaryString(1000000000));
    assertEquals(4, solution2.solution(955));
    int va = Integer.valueOf("11011101", 2);
    assertEquals(4, solution2.solution(va));
    assertEquals(4, solution2.solution(Integer.valueOf("10111011", 2)));
    assertEquals(3, solution2.solution(Integer.valueOf("10110110", 2)));
    assertEquals(4, solution2.solution(Integer.valueOf("101110111", 2)));
  }


}