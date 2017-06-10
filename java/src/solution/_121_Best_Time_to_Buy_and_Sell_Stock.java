package solution;

/**
 * @author sanguan.tangsicheng on 2017/5/19 上午11:47
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        return drive(prices, 0, prices.length - 1);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            int result = Integer.MIN_VALUE;
            int low = prices[0];
            for (int i = 1; i < prices.length; i++) {
                low = Math.max(low, prices[i]);
                result = Math.max(result, prices[i] - low);
            }
            return result;
        }

    }

    private int drive(int[] prices, int l, int r) {
        if (l >= r) {
            return 0;
        } else {
            int result = Integer.MIN_VALUE;
            int minIndex = l;
            int maxIndex = r;
            for (int i = l; i <= r; i++) {
                if (prices[i] >= prices[maxIndex]) {
                    maxIndex = i;
                }
                if (prices[i] < prices[minIndex] && i <= maxIndex) {
                    minIndex = i;
                }

                if (prices[i] < prices[minIndex] && i > maxIndex) {
                    return Math.max(result, drive(prices, i, prices.length - 1));
                } else {
                    result = Math.max(result, prices[maxIndex] - prices[minIndex]);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10000, 9999, 9998, 9997, 9996, 9995, 9994, 9993, 9992, 9991, 9990, 9989, 9988, 9987};

        _121_Best_Time_to_Buy_and_Sell_Stock q = new _121_Best_Time_to_Buy_and_Sell_Stock();

        System.out.println(q.maxProfit(nums));

    }

}
