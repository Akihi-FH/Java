//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 997 👎 0

package leetcode.editor.cn;

public class P55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55_JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 贪心：
         * 计算最远可以到达的位置，这个位置大于等于最后一个位置时，则可到达
         *
         * for
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            int length = nums.length;
            int furthest = 0; // 当前能达到的最远的位置
            for (int i = 0; i < length; i++) { // i:索引位置
                if (i <= furthest) { // i在当前所能到达最远范围内为起点继续跳跃
                    // 求最远能达到的位置的索引
                    furthest = Math.max(furthest, nums[i] + i);
                    if (furthest >= length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }


        /**
         * 贪心
         * while
         * @param nums
         * @return
         */
        /*public boolean canJump(int[] nums) {
            int length = nums.length;
            int furthest = 0; // 当前能达到的最远的位置
            int index = 0; // 位置索引
            while (index < length) {
                if (index <= furthest) { // 在当前所能到达最远范围内为起点继续跳跃
                    // 求最远能达到的位置的索引
                    furthest = Math.max(furthest, nums[index] + index);
                    if (furthest >= length - 1) {
                        return true;
                    }
                }
                index++;
            }
            return false;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}

