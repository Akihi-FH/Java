//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 791 👎 0

package leetcode.editor.cn;

public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false) - 1;
            if (left <= right && right < nums.length
                    && nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            }
            return new int[]{-1, -1};
        }
        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @param lower  决定是找第一个还是找最后一个
         *               true - 第一个
         *               false - 最后一个
         * @return 第一个位置的索引 / 最后一个位置的后一个索引
         */
        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, index = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    index = mid;
                } else {
                    left = mid + 1;
                }
            }
            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

