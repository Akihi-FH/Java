//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 850 👎 0

package leetcode.editor.cn;

public class P62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new P62_UniquePaths().new Solution();
        solution.uniquePaths(23,12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * f(i,j)：走到 (i,j) 的路径数量
         * 走到f(i,j) 可以从(i-1, j)向下走一步，或者从(i, j-1) 向右走一步
         * 走到 (i,j)的路径数 = 走到(i-1, j)的路径数 + 走到(i, j-1)的路径数
         * f(i,j) = f(i-1, j) + f(i, j-1)
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m-1][n-1];
        }

        /**
         * 组合数学
         * 从左上角到右下角的过程中，我们需要移动 m+n−2 次，
         * 其中有 m−1 次向下移动，n−1 次向右移动。
         * 因此路径的总数，就等于从 m+n−2 次移动中选择 m−1 次向下移动的方案数，
         * 即组合数.
         *
         * @param m
         * @param n
         * @return
         */
        /*public int uniquePaths(int m, int n) {
            long res = 1;
            // 分子 = (m+n−2)(m+n−3)...n ; n = m+n-1 - (m-1) + 1
            // 分母 = (m-1)!
            for (int x = n, y = 1; y < m; x++, y++) {
                res = res * x / y;
            }
            return (int) res;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

