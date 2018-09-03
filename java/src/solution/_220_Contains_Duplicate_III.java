package solution;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author jade on 2017/7/12 下午11:47
 */
public class _220_Contains_Duplicate_III {

  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Entry> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(new Entry(nums[i], i));
    }
    for (Entry entry : set) {
      Entry e = new Entry(entry.value + k + 1, entry.index + t + 1);
      NavigableSet<Entry> s1 = set.subSet(entry, true, e, false);
      if (!s1.isEmpty()) {
        return true;
      }
      e = new Entry(entry.value + k + 1, entry.index - t - 1);
      s1 = set.subSet(entry, true, e, false);
      if (!s1.isEmpty()) {
        return true;
      }
    }
    return false;
  }

  public static class Entry implements Comparable<Entry> {

    int value;
    int index;

    public Entry(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Entry that) {
      if (that.value == this.value) {
        return this.index - that.index;
      } else {
        return this.value - that.value;
      }
    }

  }

  public static void main(String[] args) {
    int[] i = new int[]{0};
    int k = 0;
    int t = 0;
    containsNearbyAlmostDuplicate(i, k, t);
  }


}
