package leetcode;

public class _277_Find_the_Celebrity {

  private boolean knows(int i, int j) {
    return true;
  }

  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 0; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i == candidate) {
        continue;
      }else {
        if (knows(candidate, i) || !knows(i, candidate)) {
          return -1;
        }
      }
    }
    return candidate;
  }


}
