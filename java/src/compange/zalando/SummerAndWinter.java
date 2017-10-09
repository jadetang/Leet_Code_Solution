package compange.zalando;

/**
 * @author sanguan.tangsicheng on 2017/7/5 上午8:05
 */
public class SummerAndWinter {

  public static int solution(int[] T) {
    // write your code in Java SE 8

    int[] maxSoFar = new int[T.length];

    maxSoFar[0] = T[0];

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < T.length; i++) {
      max = Math.max(max, T[i]);
      maxSoFar[i] = max;
    }

    int min = Integer.MAX_VALUE;

    int[] minSoFarReverse = new int[T.length];

    for (int i = T.length - 1; i >= 0; i--) {
      min = Math.min(min, T[i]);
      minSoFarReverse[i] = min;
    }

    int length = Integer.MAX_VALUE;

    for (int i = 0; i < T.length - 1; i++) {
      int length1 = 0;
      if (maxSoFar[i] < minSoFarReverse[i + 1]) {
        length1 = i;
        length = Math.min(length1, length);
      }


    }
    return length + 1;


  }

  public static void main(String[] args) {
    int[] t = new int[]{5, -2, 3, 8, 6};
    int[] t2 = new int[]{-5, -5, -5, -42, 6, 12};
    System.out.println(solution(t));
    System.out.println(solution(t2));
  }
}
