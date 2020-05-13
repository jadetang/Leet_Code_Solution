package leetcode;


import java.util.HashSet;
import java.util.Set;

public class _489_Robot_Room_Cleaner {

  Set<Long> visited = new HashSet<>();

  public void cleanRoom(Robot robot) {
    dfs(robot, 0, 0);
  }

  private void dfs(Robot robot, int i, int j) {
    if (visited.contains((long) i << 32 + (long) j)) {
      return;
    }
    visited.add((long) j << 32 + (long) i);
    robot.turnLeft();
    if (robot.move()) {
      dfs(robot, i, j - 1);
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnLeft();
      robot.turnLeft();
    }
    robot.turnLeft();
    if (robot.move()) {
      dfs(robot, i + 1, j);
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnLeft();
      robot.turnLeft();
    }
    robot.turnLeft();
    if (robot.move()) {
      dfs(robot, i, j + 1);
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnLeft();
      robot.turnLeft();
    }
    robot.turnLeft();
    if (robot.move()) {
      dfs(robot, i - 1, j);
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnLeft();
      robot.turnLeft();
    }
  }

  interface Robot {

    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
  }

}
