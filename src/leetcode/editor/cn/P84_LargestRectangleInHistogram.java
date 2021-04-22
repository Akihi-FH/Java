//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1308 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调栈 + 常数优化
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            // 从左向右遍历时，记录每个柱子左边且最近的小于其高度的柱子索引
            int[] left = new int[n];
            // 从右向左遍历时，记录每个柱子右边且最近的小于其高度的柱子索引
            int[] right = new int[n];
            Deque<Integer> stack = new LinkedList<>();
            // 记录有边界的数组 全部填充为 n
            Arrays.fill(right, n);
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    // 当栈顶元素表示的位置 i‘ 出栈时，i’位置柱子的右边界即为 i，因为此时i位置柱子的高度小于 i' 的高度
                    right[stack.peek()] = i;
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, (right[i]- left[i] -1) * heights[i]);
            }
            return res;
        }


        /**
         * 单调栈
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea2(int[] heights) {
            int n = heights.length;
            // 从左向右遍历时，记录每个柱子左边且最近的小于其高度的柱子索引
            int[] left = new int[n];
            // 从右向左遍历时，记录每个柱子右边且最近的小于其高度的柱子索引
            int[] right = new int[n];
            // 单调栈
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                // 栈不为空 且 栈顶索引所表示的柱子高度 > 当前柱子高度，出栈
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                // i位置的柱子左边且最近的小于其高度的柱子索引
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                // 柱子i位置入栈
                stack.push(i);
            }

            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                // 栈不为空 且 栈顶索引所表示的柱子高度 > 当前柱子高度，出栈
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                // i位置的柱子右边且最近的小于其高度的柱子索引
                right[i] = stack.isEmpty() ? n : stack.peek();
                // 柱子i位置入栈
                stack.push(i);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

