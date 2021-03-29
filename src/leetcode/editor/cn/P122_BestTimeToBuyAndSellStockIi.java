//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1163 👎 0

package leetcode.editor.cn;

public class P122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心算法：
         * 计算最大值 而不是实际交易过程
         * 使 x个长度为 1 的区间的收益 的 总和最大
         * @param prices
         * @return
         */
        /*
        public int maxProfit(int[] prices) {
            int max = 0;
            int n = prices.length;
            for (int i = 1; i < n; i++) {
                max = max + Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }
        */


        /**
         * 动态规划
         * dp[i][0]: 第i天交易完后手里没有股票的最大利润
         * dp[i][1]: 第i天交易完后手里有股票的最大利润
         * 那么
         * dp[i][0] = 前一天没有股票的利润 和 前一天有股票加上今天卖出的利润 中的大值：
         * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
         *
         * dp[i][1] = 前一天没有股票的利润减去今天买入股票的价格 和 前一天有股票的利润 中的大值：
         * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0;
            int dp1 = -prices[0];
            for (int i = 1; i < n; i++) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }

        /*public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}

