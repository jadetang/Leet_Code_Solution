package company.booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

/**
 * @author jade on 2017/6/24 下午3:28
 */
public class ArrayIntersect {

  public static void main(String[] args) {
    int[][] arrays = new int[][]{{2, 3, 1}, {2, 5, 3}, {2, 3, 1}};
    int[] result = intersect(arrays);
    IntStream.of(result).forEach(System.out::println);
  }

  public static int[] intersect(int[][] arrays) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arrays.length; i++) {
      for (int num : arrays[i]) {
        map.put(num, map.getOrDefault(num, 0) + i + 1);
      }

    }
    int[] result = map.entrySet().stream().filter(
        integer -> integer.getValue().equals(((1 + arrays.length) * arrays.length) / 2))
        .mapToInt(Entry::getKey).toArray();
    return result;
  }

}
