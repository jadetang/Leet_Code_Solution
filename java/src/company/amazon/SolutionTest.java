package company.amazon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

  Solution solution = new Solution();

  @Test
  public void testZero() {
    assertEquals(0, solution.solution(0));
    assertEquals(910, solution.solution(109));
  }

  @Test
  public void test9() {
    assertEquals(91, solution.solution(19));
    assertEquals(9921, solution.solution(1299));
    assertEquals(321, solution.solution(213));
    assertEquals(553, solution.solution(553));
  }
}