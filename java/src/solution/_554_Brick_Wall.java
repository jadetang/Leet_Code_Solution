package solution;

import java.util.*;
import java.util.stream.Collectors;
import util.Assert;

/**
 * @author jade on 2017/8/8 下午10:55
 */
public class _554_Brick_Wall {

  public static int leastBricks(List<List<Integer>> wall) {
    List<Set<Integer>> walls = wall.stream().map(_554_Brick_Wall::transform)
        .collect(Collectors.toList());
    int wallNumber = walls.size();
    int min = wallNumber - 1;
    for (Set<Integer> w : walls) {
      Iterator<Integer> it = w.iterator();
      while (it.hasNext()) {
        Integer i = it.next();
        int matchWalls = 1;
        for (Set<Integer> otherW : walls) {
          if (otherW != w) {
            if (otherW.remove(i)) {
              matchWalls++;
            }
          }
        }
        it.remove();
        min = Math.min(min, wallNumber - matchWalls);
      }
    }
    return min;
  }

  private static Set<Integer> transform(List<Integer> list) {
    Set<Integer> set = new HashSet<>();
    int sum = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      sum += list.get(i);
      set.add(sum);
    }
    return set;
  }


  public int leastBricks2(List<List<Integer>> walls) {
    List<Integer> firstWall = walls.get(0);
    int length = firstWall.stream().reduce((i1, i2) -> i1 + i2).get();
    int[] count = new int[length];
    for (List<Integer> wall : walls) {
      int sum = 0;
      for (int i = 0; i < wall.size() - 1; i++) {
        sum += wall.get(i);
        count[sum]++;
      }
    }
    int min = walls.size();
    int wallSize = min;
    for (int i : count) {
      min = Math.min(min, wallSize - i);
    }
    return min;
  }

  public static void main(String[] args) {
    test1();
  }

  private static void test1() {
    List<Integer> wall1 = Arrays.asList(1, 2, 2, 1);
    List<Integer> wall2 = Arrays.asList(3, 1, 2);
    List<Integer> wall3 = Arrays.asList(1, 3, 2);
    List<Integer> wall4 = Arrays.asList(2, 4);
    List<Integer> wall5 = Arrays.asList(3, 1, 2);
    List<Integer> wall6 = Arrays.asList(1, 3, 1, 1);

    List<List<Integer>> walls = Arrays.asList(wall1, wall2, wall3, wall4, wall5, wall6);

    Assert.assertEqual(2, leastBricks(walls));

  }

}
