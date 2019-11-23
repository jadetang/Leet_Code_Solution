package leetcode;

public class _657_Robot_Return_To_Origin {

  public boolean judgeCircle(String moves) {
    char[] chars = moves.toCharArray();
    if (chars.length % 2 == 1) {
      return false;
    } else {
      int vertical = 0;
      int horizontal = 0;
      for (char c : chars) {
        if (c == 'U') {
          vertical++;
        } else if (c == 'D') {
          vertical--;
        } else if (c == 'L') {
          horizontal--;
        } else if (c == 'R') {
          horizontal++;
        }
      }
      return vertical == 0 && horizontal == 0;
    }
  }

}
