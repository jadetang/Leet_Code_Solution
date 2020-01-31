package company.amazon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DispensersWaitingSimulatorTest {

  DispensersWaitingSimulator solution3 = new DispensersWaitingSimulator();


  @Test
  public void test() {
    assertEquals(8, solution3.solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
    assertEquals(-1, solution3.solution(new int[]{2, 8, 4, 3, 2}, 0, 0, 0));
    assertEquals(-1, solution3.solution(new int[]{2, 8, 4, 3, 2}, 0, 11, 3));
    assertEquals(3, solution3.solution(new int[]{3, 2, 4, 3}, 8, 4, 10));
    assertEquals(-1, solution3.solution(new int[]{5}, 4, 0, 3));


  }


}