package company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Newstore {


  static int[] ROW_DIRECTION = new int[]{1, 0, -1, 0};
  static int[] COL_DIRECTION = new int[]{0, 1, 0, -1};

  public static int OneDecremented(int num) {
    String value = String.valueOf(num);
    int ans = 0;
    for (int i = 1; i < value.length(); i++) {
      if (value.charAt(i) + 1 == value.charAt(i - 1)) {
        ans++;
      }
    }
    return ans;
  }

  public static int SeatingStudents(int[] arr) {
    //true means the desk is already taken
    boolean[][] desk = new boolean[arr[0] / 2][2];
    for (int i = 1; i < arr.length; i++) {
      int row = (arr[i] - 1) / 2;
      int col = (arr[i] - 1) % 2;
      desk[row][col] = true;
    }
    Set<DeskPair> pairSet = new HashSet<>();
    for (int i = 0; i < desk.length; i++) {
      for (int j = 0; j < desk[0].length; j++) {
        if (!desk[i][j]) {
          for (int k = 0; k < ROW_DIRECTION.length; k++) {
            int nextRow = i + ROW_DIRECTION[k];
            int nextCol = j + COL_DIRECTION[k];
            if (nextRow >= 0 && nextRow < desk.length && nextCol >= 0 && nextCol < 2
                && !desk[nextRow][nextCol]) {
              pairSet.add(new DeskPair(i * 2 + j, nextRow * 2 + nextCol));
            }
          }
        }
      }
    }
    return pairSet.size();
    // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */

  }

  public static void main(String[] args) {
    // keep this function call here
    System.out.println(SeatingStudents(new int[]{4}));
  }

  public static class DeskPair {

    int desk1;

    int desk2;

    public DeskPair(int desk1, int desk2) {
      if (desk1 >= desk2) {
        this.desk1 = desk2;
        this.desk2 = desk1;
      } else {
        this.desk1 = desk1;
        this.desk2 = desk2;
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      DeskPair deskPair = (DeskPair) o;
      return desk1 == deskPair.desk1 &&
          desk2 == deskPair.desk2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(desk1, desk2);
    }
  }


}
