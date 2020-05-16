package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _489_Robot_Room_Cleaner {

    Robot robot;

    Set<String> cache;

    enum Direction {
        up, left, right, down
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.cache = new HashSet<>();
        dfs(0, 0, Direction.up);
    }

    private void dfs(int i, int j, Direction direction) {
        if (cache.contains(i + ":" + j)) {
            return;
        }
        cache.add(i + ":" + j);
        robot.clean();
        for (int k = 0; k < 4; k++) {
            if (robot.move()) {
                int nextI = nextI(i, direction);
                int nextj = nextJ(j, direction);
                dfs(nextI, nextj, nextDirection(direction));
                moveBack();
            }
            robot.turnRight();
            direction = nextDirection(direction);
        }
    }

    private void moveBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    private Direction nextDirection(Direction direction) {
        switch (direction) {
            case up:
                return Direction.right;
            case right:
                return Direction.down;
            case down:
                return Direction.left;
            case left:
                return Direction.up;
            default:
                throw new RuntimeException();
        }
    }

    private int nextI(int i, Direction direction) {
        if (direction == Direction.up) {
            return i - 1;
        }
        if (direction == Direction.down) {
            return i + 1;
        }
        return i;
    }

    private int nextJ(int j, Direction direction) {
        if (direction == Direction.left) {
            return j - 1;
        }
        if (direction == Direction.right) {
            return j + 1;
        }
        return j;
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
