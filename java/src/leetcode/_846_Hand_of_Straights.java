package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class _846_Hand_of_Straights {

    @Test
    public void test() {
        int[] cards = new int[]{1,2,3,6,2,3,4,7,8};
        _846_Hand_of_Straights q = new _846_Hand_of_Straights();
        Assert.assertTrue(q.isNStraightHand(cards, 3));
    }

    public boolean isNStraightHand(int[] hand, int w) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            count.put(hand[i], count.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            int current = hand[i];
            if (count.get(current) != null) {
                for (int j = current; j < current + w; j++) {
                    if (count.get(j) == null) {
                        return false;
                    }
                    count.put(j, count.get(j) - 1);
                    if (count.get(j) == 0) {
                        count.remove(j);
                    }
                }
            }
        }
        return true;
    }
}
