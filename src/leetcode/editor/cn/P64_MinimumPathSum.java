//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 755 👎 0

package leetcode.editor.cn;

public class P64_MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new P64_MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * f(i,j): 走到(i,j)时的最小路径数字和
         * 走到f(i,j) 可以从(i-1, j)向下走一步，或者从(i, j-1) 向右走一步
         * 走到 (i,j)的最小路径和
         *      =  到(i-1, j)的最小路径和 与 到(i, j-1)的最小路径和 的最小值
         *       + (i,j)处的值
         * f(i,j) = min( f(i-1,j), f(i,j-1) ) + grid(i,j)
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            if (grid[0].length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            int[][] dp = new int[row][col];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < row; i++) {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for (int j = 1; j < col; j++) {
                dp[0][j] = dp[0][j-1] + grid[0][j];
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[row-1][col-1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

