package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _1000_Minimum_Cost_to_Merge_Stones {

    int cost = 0;

    @Test
    public void test1() {
        int[] stones = new int[]{3, 5, 1, 2, 6};
        _1000_Minimum_Cost_to_Merge_Stones q = new _1000_Minimum_Cost_to_Merge_Stones();
        Assert.assertEquals(25, q.mergeStones(stones, 3));
        Assert.assertEquals(20, q.mergeStones(new int[]{3, 2, 4, 1}, 2));
    }

    public int mergeStones(int[] stones, int k) {
        cost = 0;
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        while (stones.length != 1) {
            stones = mergeOnePile(stones, k);
        }
        return cost;
    }

    private int[] mergeOnePile(int[] stones, int k) {
        int[] newStore = new int[stones.length - k + 1];
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int j = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
            if (i - j + 1 > k) {
                sum -= stones[j];
                j++;
            }
            if (i - j + 1 == k) {
                if (sum < minSum) {
                    left = j;
                    right = i;
                    minSum = sum;
                }
            }
        }
        int index = 0;
        for (int i = 0; i < stones.length; i++) {
            if (i >= left && i < right) {
                continue;
            } else if (i == right) {
                newStore[index++] = minSum;
            } else {
                newStore[index++] = stones[i];
            }
        }
        cost += minSum;
        return newStore;
    }

}
