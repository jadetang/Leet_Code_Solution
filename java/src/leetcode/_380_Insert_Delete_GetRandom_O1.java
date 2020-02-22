package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author jade on 16/8/4 下午10:54
 */
public class _380_Insert_Delete_GetRandom_O1 {

  private ArrayList<Integer> array = new ArrayList<>();

  private HashMap<Integer, Integer> index = new HashMap<>();

  private Random random = new Random();

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (index.keySet().contains(val)) {
      return false;
    } else {
      index.put(val, array.size());
      array.add(val);
      return true;
    }
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    if (!index.keySet().contains(val)) {
      return false;
    } else {
      int oldIndex = index.get(val);
      index.put(array.get(array.size() - 1), oldIndex);
      array.set(oldIndex,array.get(array.size() - 1));
     // switchVal(oldIndex, array.size() - 1);
      array.remove(array.size() - 1);
      index.remove(val);
      return true;
    }
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    int index = random.nextInt(array.size());
    return array.get(index);
  }
}
