package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _957_Prison_Cells_After_N_Days {


  public static void main(String[] args) {
    _957_Prison_Cells_After_N_Days q = new _957_Prison_Cells_After_N_Days();
    int[] array = new int[]{0, 0, 1, 1, 0, 0, 1, 0};
    int[] resut = q.prisonAfterNDays(array, 722542773);
    System.out.println(Arrays.toString(resut));
  }


  public int[] prisonAfterNDays(int[] cells, int N) {
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int cur = toInt(cells);
    int circleSize = -1;
    map.put(cur, 0);
    while (i < N) {
      //  System.out.println(Integer.toBinaryString(cur));
      i++;
      cur = next(cur);
      if (map.containsKey(cur)) {
        int t = map.get(cur);
        circleSize = i - t;
        i += ((N - i) / circleSize) * circleSize;
        break;
      } else {
        map.put(cur, i);
      }
    }
    for (; i < N; i++) {
      cur = next(cur);
    }
    return toIntArray(cur);
  }

  private int toInt(int[] arrays) {
    int result = 0;
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i] == 1) {
        result ^= (1 << (7 - i));
      }
    }
    return result;
  }


  private int[] toIntArray(int cur) {
    int[] res = new int[8];
    for (int i = 0; i < 8; i++) {
      if ((cur >> (7 - i) & 1) > 0) {
        res[i] = 1;
      }
    }
    return res;
  }

  public int next(int state) {
    int ans = 0;

    // We only loop from 1 to 6 because 0 and 7 are impossible,
    // as those cells only have one neighbor.
    for (int i = 6; i >= 1; --i) {
      int left = (state >> (i + 1)) & 1;
      int right = (state >> (i - 1)) & 1;
      if (left == right) {
        ans ^= 1 << i;
      }
    }
    return ans;
  }

}
