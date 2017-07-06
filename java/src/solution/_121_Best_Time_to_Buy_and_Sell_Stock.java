package solution;

/**
 * @author sanguan.tangsicheng on 2017/5/19 上午11:47
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {



    // 记录当前遇见的最小的值
    public int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        int[] nums = new int[] {10000, 9999, 9998, 9997, 9996, 9995, 9994, 9993, 9992, 9991, 9990, 9989, 9988, 9987};

        _121_Best_Time_to_Buy_and_Sell_Stock q = new _121_Best_Time_to_Buy_and_Sell_Stock();

        System.out.println(q.maxProfit(nums));

    }

}
