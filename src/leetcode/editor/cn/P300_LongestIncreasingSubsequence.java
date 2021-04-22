//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1542 👎 0

package leetcode.editor.cn;

public class P300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贪心 + 二分查找
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int n = nums.length;
            // 数组维持一个上升子序列
            int[] d = new int[n + 1];
            // len维持数组长度
            int len = 1;
            d[len] = nums[0];
            for (int i = 0; i < n; i++) {
                // 若 num[i] > 数组中最后一个数，则将num[i]加入数组
                if (nums[i] > d[len]) {
                    d[++len] = nums[i];
                } else {
                    // 否则将 nums[i] 替换到数组中合适的位置，即数组d中小于nums[i]的最大数位置 + 1
                    // 查找合适位置时使用二分查找法
                    int l = 1, r = len;
                    // nums[i]合适位置的前一个位置，也就是数组d中小于nums[i]的最大数位置
                    int index = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] < nums[i]) {
                            index = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    // 替换为 nums[i]
                    d[index + 1] = nums[i];
                }
            }
            // 最终数组d的长度就是最长上升子序列的长度
            return len;
        }

        /**
         * 动态规划
         * dp[i] : 以i结尾的最长上升子序列长度
         * dp[i] = max(dp[j]) + 1 ,  0 <= j < i && nums[j] < nums[i]
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS2(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                // 初始化为 1
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 若有 nums[j] < nums[i]
                    if (nums[j] < nums[i]) {
                        // dp[i] = 所有 dp[j] + 1 中的最大值
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // 更新最大长度
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

