package solution;

import java.util.*;

/**
 * @author sanguan.tangsicheng on 16/8/4 下午10:54
 */
public class _380_Insert_Delete_GetRandom_O1 {

    private ArrayList<Integer> array = new ArrayList<>();

    private HashMap<Integer, Integer> index = new HashMap<>();

    private Random random = new Random();


    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
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
            switchVal(oldIndex, array.size() - 1);
            array.remove(array.size() - 1);
            index.remove(val);
            return true;
        }
    }


    private void switchVal(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return;
        } else {
            int temp = array.get(leftIndex);
            array.set(leftIndex, array.get(rightIndex));
            index.put(array.get(rightIndex), leftIndex);
            array.set(rightIndex, temp);
            index.put(temp, rightIndex);
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(array.size());
        return array.get(index);
    }

    public static void main(String[] args) {
        _380_Insert_Delete_GetRandom_O1 r = new _380_Insert_Delete_GetRandom_O1();
        r.insert(0);
        r.remove(0);
        r.insert(-1);
        r.remove(0);
        for (int i = 0; i < 100; i++) {
            r.getRandom();
        }
    }
}
