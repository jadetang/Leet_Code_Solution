package solution;

import level.Hard;

import java.util.*;

/**
 * @author jade on 2016/12/1 上午7:42
 */
public class _381_Insert_Delete_GetRandom_O1_Duplicates_allowed implements Hard {

  public class RandomizedCollection {

    private Map<Integer, TreeSet<Integer>> indexMap;

    private ArrayList<Integer> data;

    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
      indexMap = new HashMap<>();
      data = new ArrayList<>();
      random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the
     * specified element.
     */
    public boolean insert(int val) {
      TreeSet<Integer> indexSet = indexMap.getOrDefault(val, new TreeSet<>());
      data.add(val);
      indexSet.add(data.size() - 1);
      indexMap.put(val, indexSet);
      return indexSet.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified
     * element.
     */
    public boolean remove(int val) {
      TreeSet<Integer> indexSet = indexMap.get(val);
      if (indexSet == null) {
        return false;
      } else {
        Integer index = indexSet.pollLast();
        Integer tail = data.get(data.size() - 1);
        if (!index.equals(tail)) {
          indexMap.get(tail).pollLast();
          indexMap.get(tail).add(index);
          data.set(index, tail);
        }
        data.remove(data.size() - 1);
        return true;
      }
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
      return data.get(random.nextInt(data.size()));
    }
  }

}
