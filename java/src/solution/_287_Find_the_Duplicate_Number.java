package solution;

import java.util.BitSet;

/**
 * @author jade on 2016/12/15 上午9:15
 */
public class _287_Find_the_Duplicate_Number {

  //用 bit set。也可用用快慢指针来做
  public static int findDuplicate(int[] nums) {
    BitSet b = new BitSet();
    for (int i : nums) {
      if (b.get(i)) {
        return i;
      } else {
        b.flip(i);
      }
    }
    return -1;
  }

  public static int findDuplicate2(int[] nums) {
    int slow = 0;
    int fast = 0;
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) {
        break;
      }
    }
    int head = 0;
    while (true) {
      slow = nums[slow];
      head = nums[head];
      if (slow == head) {
        return slow;
      }
    }
  }

  public static void main(String[] args) {
    int[] ints = new int[]{2, 2, 2, 2};
    System.out.println(findDuplicate(ints));
    System.out.println(findDuplicate2(ints));
  }

}
