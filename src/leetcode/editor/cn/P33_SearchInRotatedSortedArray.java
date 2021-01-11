//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1112 👎 0

package leetcode.editor.cn;

public class P33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{3,1};
        System.out.println(solution.search(nums, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                // 若成立，左边 nums[left] 至 nums[mid-1] 有序；否则 nums[mid+1] 至 nums[right] 有序
                if (nums[left] <= nums[mid]) { // nums[left] 至 nums[mid] 有序
                    // target 在 nums[left] 和 nums[mid]之间
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else { // nums[mid + 1] 至 nums[right] 有序
                    // target 在 nums[mid] 和 nums[right] 之间
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

