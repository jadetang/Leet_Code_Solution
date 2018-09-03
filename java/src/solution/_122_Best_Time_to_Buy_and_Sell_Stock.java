package solution;

/**
 * https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
 *
 * @author jade on 2017/7/2 下午2:50
 */
public class _122_Best_Time_to_Buy_and_Sell_Stock {

  /**
   * If we analyze the graph, we notice that the points of interest are the consecutive valleys and
   * peaks.
   *
   * Mathematically speaking: Total Profit= \sum_{i}(height(peak_i)-height(valley_i)) TotalProfit=
   * ​i ​∑ ​​ (height(peak ​i ​​ )−height(valley ​i ​​ ))
   *
   * The key point is we need to consider every peak immediately following a valley to maximize the
   * profit. In case we skip one of the peaks (trying to obtain more profit), we will end up losing
   * the profit over one of the transactions leading to an overall lesser profit.
   *
   * For example, in the above case, if we skip peak_ipeak ​i ​​  and valley_jvalley ​j ​​  trying
   * to obtain more profit by considering points with more difference in heights, the net profit
   * obtained will always be lesser than the one obtained by including them, since CC will always be
   * lesser than A+BA+B.
   */

  public int maxProfit2(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }

  /**
   * This solution follows the logic used in Approach 2 itself, but with only a slight variation. In
   * this case, instead of looking for every peak following a valley, we can simply go on crawling
   * over the slope and keep on adding the profit obtained from every consecutive transaction. In
   * the end,we will be using the peaks and valleys effectively, but we need not track the costs
   * corresponding to the peaks and valleys along with the maximum profit, but we can directly keep
   * on adding the difference between the consecutive numbers of the array if the second number is
   * larger than the first one, and at the total sum we obtain will be the maximum profit. This
   * approach will simplify the solution. This can be made clearer by taking this example:
   */

  class Solution {

    public int maxProfit(int[] prices) {
      int maxprofit = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
          maxprofit += prices[i] - prices[i - 1];
        }
      }
      return maxprofit;
    }
  }
}
