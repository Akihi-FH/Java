package sword.one.array;

/**
 * 股票的最大利润
 */
class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            max = Math.max(max, price - buy);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        // 前 i 日最大利润 = max(前i-1日最大利润， 第i日价格 - 前i日最低价格)
        int[] dp = new int[length];
        dp[0] = 0;
        int buy = prices[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return dp[length - 1];
    }
}

public class P63_MaxProfit {
}
