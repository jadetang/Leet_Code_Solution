package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
 * favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a
 * choice tie between answers, output all of them with no order requirement. You could assume there
 * always exists an answer.
 *
 * Example 1: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"] ["Piatti", "The Grill at
 * Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"] Output: ["Shogun"] Explanation: The only
 * restaurant they both like is "Shogun". Example 2: Input: ["Shogun", "Tapioca Express", "Burger
 * King", "KFC"] ["KFC", "Shogun", "Burger King"] Output: ["Shogun"] Explanation: The restaurant
 * they both like and have the least index sum is "Shogun" with index sum 1 (0+1). Note: The length
 * of both lists will be in the range of [1, 1000]. The length of strings in both lists will be in
 * the range of [1, 30]. The index is starting from 0 to the list length minus 1. No duplicates in
 * both lists.
 *
 * @author sanguan.tangsicheng on 2017/6/4 上午10:54
 */
public class _599_Minimum_Index_Sum_of_Two_Lists {


  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> dict1 = buildDict(list1);
    Map<String, Integer> dict2 = buildDict(list2);
    int min = Integer.MAX_VALUE;
    for (String str : list1) {
      if (dict2.containsKey(str)) {
        min = Math.min(dict1.get(str) + dict2.get(str), min);

      }
    }
    if (min == Integer.MAX_VALUE) {
      return null;
    } else {
      List<String> result = new LinkedList<>();
      for (String str : list1) {
        if (dict2.containsKey(str) && min == dict1.get(str) + dict2.get(str)) {
          result.add(str);

        }
      }
      return result.toArray(new String[]{});
    }
  }

  private Map<String, Integer> buildDict(String[] str) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length; i++) {
      map.put(str[i], i);
    }
    return map;
  }
}
