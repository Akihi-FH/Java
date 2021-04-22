//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 877 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P85_MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85_MaximalRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 单调栈 + 柱状图
         * @param matrix
         * @return
         */
        public int maximalRectangle(char[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) {
                return 0;
            }
            int cols = matrix[0].length;

            int[][] left = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '1') {
                        left[i][j] = (j == 0 ? 0 : left[i - 1][j]) + 1;
                    }
                }
            }

            // 对于每一列 使用基于柱状图的单调栈解法
            int res = 0;
            for (int j = 0; j < cols; j++) {
                int[] up = new int[rows];
                int[] down = new int[rows];
                Deque<Integer> stack = new LinkedList<>();
                for (int i = 0; i < rows; i++) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop();
                    }
                    up[i] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(i);
                }
                stack.clear();
                for (int i = rows - 1; i >= 0; i--) {
                    while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                        stack.pop();
                    }
                    down[i] = stack.isEmpty() ? rows : stack.peek();
                    stack.push(i);
                }

                for (int i = 0; i < rows; i++) {
                    int height = down[i] - up[i] - 1;
                    int area = height * left[i][j];
                    res = Math.max(res, area);
                }
            }
            return res;
        }


        /**
         * 循环，柱状图
         *
         * @param matrix
         * @return
         */
        public int maximalRectangle2(char[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) {
                return 0;
            }
            int cols = matrix[0].length;
            // 以[i][j]为起点，统计左边 1 的个数，遇到 0，则停止统计
            // [i][j]、[i][j-1]、[i][j-2]
            int[][] left = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '1') {
                        left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    }
                }
            }
            // 结果
            int res = 0;
            // 遍历横纵坐标，计算最大面积
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 遇到 0，则跳过
                    if (left[i][j] == '0') {
                        continue;
                    }
                    // 以[i][j]为矩形右下角的宽度
                    int width = left[i][j];
                    // 面积
                    int area = width;
                    // k：从i行向上遍历
                    for (int k = i - 1; k >= 0; k--) {
                        // i行到k行的最小宽度
                        width = Math.min(width, left[k][j]);
                        // i-k+1 : 当前高度；新的area = 高度 * （i行到k行的最小宽度）
                        area = Math.max(area, (i - k + 1) * width);
                    }
                    // 面积最大值
                    res = Math.max(res, area);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

