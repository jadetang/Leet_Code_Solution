package lintcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _92_Backpack {


  int ans = 0;

  public static void main(String[] args) {
    _92_Backpack q = new _92_Backpack();
    int[] data = new int[]{3, 4, 8, 5};
    System.out.println(q.backPack2(10, data));
    System.out.println(q.backPack3(10, data));
  }

  public int backPack(int m, int[] A) {
    dfs(A, m, 0, 0);
    return ans;
    // write your code here
  }

  private void dfs(int[] size, int maxSize, int curSize, int start) {
    ans = Math.max(ans, curSize);
    if (start >= size.length) {
      return;
    }
    for (int i = start; i < size.length; i++) {
      if (curSize + size[i] <= maxSize) {
        dfs(size, maxSize, curSize + size[i], i + 1);
      }
    }
  }

  public int backPack3(int m, int[] a) {
    int[] size = new int[m + 1];
    int[] temp = new int[m + 1];
    int ans = 0;
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= m; j++) {
        if (j >= a[i - 1]) {
          temp[j] = Math.max(size[j], size[j - a[i - 1]] + a[i - 1]);
        } else {
          temp[j] = size[j];
        }
      }
      int[] x = temp;
      temp = size;
      size = x;
    }
    return IntStream.of(size).max().getAsInt();
  }


  public int backPack2(int m, int[] A) {

    int[][] size = new int[A.length + 1][m + 1];
    int ans = 0;
    for (int i = 1; i <= A.length; i++) {
      for (int j = 0; j <= m; j++) {
        if (j >= A[i - 1]) {
          size[i][j] = Math.max(size[i - 1][j], size[i - 1][j - A[i - 1]] + A[i - 1]);
        } else {
          size[i][j] = size[i - 1][j];
        }
        ans = Math.max(ans, size[i][j]);
      }
    }
    for (int[] a : size) {
      System.out.println(Arrays.toString(a));
    }
    return ans;
  }


}
