package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import util.Assert;

public class _1088_Confusing_Number_II {

  int[] base = {0, 1, 6, 8, 9};
  int[] reverse_board = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

  @Test
  public void test() {
    _1088_Confusing_Number_II q = new _1088_Confusing_Number_II();
    Assert.assertEqual(6, q.confusingNumberII(20));
  }

  public int confusingNumberII(int N) {
    int t = N;
    int len = 0;
    while (t > 0) {
      t /= 10;
      len++;
    }
    int ans = 0;
    if (len == 10) {
      N -= 1;
      ans = 1;
      len -= 1;
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    int ori = 0;
    for (int i = 0; i < len; i++) {
      int size = queue.size();
      while (size > 0) {
        int base_i = queue.poll();
        for (int j = 0; j < 5; j++) {
          int cur = base[j];
          if (i == 0 && cur == 0) {
            continue;
          }
          //build
          ori = base_i * 10 + cur;
          if (ori <= N) {
            //store
            queue.offer(ori);
            //reverse
            int rev = reverse(ori);
            //check
            if (rev != ori) {
              ans++;
            }
          }
        }
        size--;
      }
    }
    return ans;
  }

  public int reverse(int b) {
    int a = 0;
    while (b > 0) {
      int bit = b % 10;
      b /= 10;
      a = a * 10 + reverse_board[bit];
    }
    return a;
  }

}
