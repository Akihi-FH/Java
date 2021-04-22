//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2282 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42_TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         * 左右同时计算
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int res = 0;
            // 左右柱子位置
            int left = 0, right = height.length - 1;
            // 左边更高的柱子、右边更高的柱子
            int left_max = 0, right_max = 0;
            while (left < right) {
                // 如果当前 左柱子高度 小于 右柱子高度
                if (height[left] < height[right]) {
                    // 左边没有更高的柱子，更新 左边更高的柱子 的高度
                    if (left_max <= height[left]) {
                        left_max = height[left];
                    } else { // left_max > height[left] 左边有更高的柱子，计算当前位置接水量
                        res += left_max - height[left];
                    }
                    left++;
                } else { // height[left] >= height[right] 如果当前 左柱子高度 大于 右柱子高度
                    // 右边没有更高的柱子，更新 右边更高的柱子 的高度
                    if (height[right] >= right_max) {
                        right_max = height[right];
                    } else { // right_max > height[right] 右边有更高的柱子，计算当前位置接水量
                        res += right_max - height[right];
                    }
                    right--;
                }
            }
            return res;
        }

        /**
         * 一次循环
         * 提前存储每个位置左、右边更高的柱子高度
         *
         * @param height
         * @return
         */
        public int trap2(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int res = 0;
            int n = height.length;
            // 保存下标 i 到最左端最高的柱子高度
            int[] left_max = new int[n];
            // 保存下标 i 到最右端最高的柱子高度
            int[] right_max = new int[n];
            left_max[0] = height[0];
            for (int i = 1; i < n - 1; i++) {
                left_max[i] = Math.max(height[i], left_max[i - 1]);
            }
            right_max[n - 1] = height[n - 1];
            for (int i = n - 2; i > 0; i--) {
                right_max[i] = Math.max(height[i], right_max[i + 1]);
            }
            for (int i = 1; i < n - 1; i++) {
                res += Math.min(left_max[i], right_max[i]) - height[i];
            }
            return res;
        }

        /**
         * 单调栈：保存降序的柱子高度，也为 接水坑 的左边界
         * 当前柱子高度 < 栈顶柱子高度，则当前柱子位置入栈，即当前位置柱子 左边界由栈顶位置柱子 限定
         * 当前柱子高度 > 栈顶柱子高度，则栈顶柱子所在位置 有边界 由当前柱子限定
         *
         * @param height
         * @return
         */
        public int trap3(int[] height) {
            int ans = 0, current = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            while (current < height.length) {
                while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty())
                        break;
                    int distance = current - stack.peek() - 1;
                    int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                    ans += distance * bounded_height;
                }
                stack.push(current++);
            }
            return ans;
        }


        /**
         * 暴力破解，两层循环
         *
         * @param height
         * @return
         */
        public int trap1(int[] height) {
            int n = height.length;
            int res = 0;
            for (int i = 1; i < n - 1; i++) {
                int lHeight = 0, rHight = 0;
                // 从当前元素向左扫描更高的柱子，最小值为当前高度
                for (int j = i; j >= 0; j--) {
                    lHeight = Math.max(lHeight, height[j]);
                }
                // 从当前元素向右扫描更高的柱子，最小值为当前高度
                for (int j = i; j < n; j++) {
                    rHight = Math.max(rHight, height[j]);
                }
                // 当前位置接到的雨水量 = 左右高度更小的值 - 当前高度值
                res += Math.min(lHeight, rHight) - height[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

