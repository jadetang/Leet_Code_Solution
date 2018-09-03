package solution;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a
 * function to compute the fewest number of coins that you need to make up that amount. If that
 * amount of money cannot be made up by any combination of the coins, return -1. Example 1: coins =
 * [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1) Example 2: coins = [2], amount = 3 return -1.
 *
 * @author jade on 2017/5/10 上午10:55
 */
public class _322_Coin_Change {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) {
      return 0;
    }
    int[] count = new int[amount + 1];
    count[0] = 0;
    return coinChange(coins, amount, count);
  }

  private int coinChange(int[] coins, int rem, int[] count) {
    if (rem < 0) {
      return -1;
    }
    if (rem == 0) {
      return 0;
    }
    if (count[rem] != 0) {
      return count[rem];
    }
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min) {
        min = res;
      }
    }
    count[rem] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
    return count[rem];
  }

  public static int coinChange2(int[] coins, int amount) {
    if (amount < 0) {
      return 0;
    }
    int[] count = new int[amount + 1];
    count[0] = 0;
    for (int i = 1; i <= amount; i++) {

      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= i && count[i - coin] != -1) {
          min = Math.min(count[i - coin] + 1, min);

        }
      }
      if (min == Integer.MAX_VALUE) {
        count[i] = -1;
      } else {
        count[i] = min;
      }
    }
    return count[amount];
  }

  public static void main(String[] args) {
    int[] coins = new int[]{2, 3};
    _322_Coin_Change c = new _322_Coin_Change();
    System.out.println(c.coinChange(coins, 4));
    System.out.println(c.coinChange2(coins, 4));
  }

}
