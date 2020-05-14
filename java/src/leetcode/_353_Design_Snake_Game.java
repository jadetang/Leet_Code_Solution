package leetcode;

import java.util.LinkedList;
import java.util.Objects;
import org.junit.Test;
import util.Assert;

public class _353_Design_Snake_Game {

  @Test
  public void test() {
    int width = 3;
    int height = 2;
    int[][] food = new int[][]{{1, 2}, {0, 1}};
    SnakeGame snakeGame = new SnakeGame(width, height, food);
    Assert.assertEqual(0, snakeGame.move("R"));
    Assert.assertEqual(0, snakeGame.move("D"));
    Assert.assertEqual(1, snakeGame.move("R"));
    Assert.assertEqual(1, snakeGame.move("U"));
    Assert.assertEqual(2, snakeGame.move("L"));
    Assert.assertEqual(-1, snakeGame.move("U"));
  }

  public static class SnakeGame {

    LinkedList<Point> queue = new LinkedList<>();

//    Set<Point> set = new HashSet<>();

    int width;

    int height;

    int[][] food;

    int currentFood;

    public SnakeGame(int width, int height, int[][] food) {
      this.width = width;
      this.height = height;
      this.food = food;
      this.currentFood = 0;
      Point head = new Point(0, 0);
      queue.offerFirst(head);
      //  set.add(head);
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over. Game over when snake crosses
     * the screen boundary or bites its body.
     */
    public int move(String direction) {
      Point head = queue.peekFirst();
      Point tail = queue.pollLast();
      Point nextHead = head.move(direction);
      // set.remove(queue.peekLast());
      if (nextHead.row < 0 || nextHead.row >= height || nextHead.col < 0 || nextHead.col >= width
          || queue.contains(nextHead)) {
        return -1;
      }
      //  set.add(queue.peekLast());
      if (currentFood < food.length && food[currentFood][0] == nextHead.row
          && food[currentFood][1] == nextHead.col) {
        currentFood++;
        // set.add(nextHead);
        queue.offerFirst(nextHead);
        queue.offerLast(tail);
        return queue.size() - 1;
      }
      // set.remove(queue.peekLast());
      //  queue.pollLast();
      queue.offerFirst(nextHead);
      return queue.size() - 1;
    }
  }

  public static class Point {

    int row;
    int col;

    public Point(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public Point move(String direction) {
      switch (direction) {
        case "U":
          return new Point(this.row - 1, this.col);
        case "D":
          return new Point(this.row + 1, this.col);
        case "L":
          return new Point(this.row, this.col - 1);
        case "R":
          return new Point(this.row, this.col + 1);
        default:
          throw new IllegalArgumentException(direction + " is wrong");
      }
    }

    public int getRow() {
      return row;
    }

    public int getCol() {
      return col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Point point = (Point) o;
      return row == point.row &&
          col == point.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }
}
