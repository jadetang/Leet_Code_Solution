import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempClass {

  public static long kSub(int k, List<Integer> nums) {
    Map<Integer, Long> sumCount = new HashMap<>();
    for (Integer n : nums) {
      Map<Integer, Long> tempMap = new HashMap<>();
      tempMap.put(n % k, 1L);
      for (Map.Entry<Integer, Long> entry : sumCount.entrySet()) {
        int sum = entry.getKey();
        Long count = entry.getValue();
        int newSum = (sum + n) % k;
        tempMap.put(newSum, tempMap.getOrDefault(newSum, 0L) + count);
      }
      for (Map.Entry<Integer, Long> entry : tempMap.entrySet()) {
        sumCount.put(entry.getKey(), entry.getValue() + sumCount.getOrDefault(entry.getKey(), 0L));
      }
    }
    return sumCount.getOrDefault(0, 0L);
    // Write your code here

  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    System.out.println(TempClass.kSub(3, list));
  }

}
