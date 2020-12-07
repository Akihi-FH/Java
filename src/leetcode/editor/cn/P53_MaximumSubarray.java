//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2631 👎 0

package leetcode.editor.cn;
public class P53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53_MaximumSubarray().new Solution();
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * [-2,1,-3,4,-1,2,1,-5,4]
         * 动态规划：
         *  num下一个数
         *  tmp：遍历时，当前的最大字序和：tmp是 tmp+num 与 num 中的最大值
         *      如果 tmp+num < num, tmp必为负数，num为当前最大字序和
         *      如果 tmp+num > num, tmp必为正数，tmp+num为当前最大字序和
         *  max：遍历到目前为止的最大子序和
         *      如果 max > tmp ; max为目前为止的最大子序和
         *      如果 max < tmp ; tmp为目前为止的最大子序和
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int tmp = 0, max = nums[0];
            for (int num : nums) {
                tmp = Math.max(tmp + num, num);
                max = Math.max(max, tmp);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

