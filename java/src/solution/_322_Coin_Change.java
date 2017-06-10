package solution;

/**
 * @author sanguan.tangsicheng on 2017/5/10 上午10:55
 */
public class _322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] count = new int[amount+1];
        count[0] = 0;
        return coinChange(coins, amount, count);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem] != 0) return count[rem];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = res;
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        return count[rem];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2,3};
        _322_Coin_Change c = new _322_Coin_Change();
        System.out.println(c.coinChange(coins,4));
    }

}
