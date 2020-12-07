//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 866 👎 0

package leetcode.editor.cn;

public class P283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283_MoveZeroes().new Solution();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 左指针left指向已处理好的列表的下一个元素
         * 右指针right指向下一个待处理的元素
         * right遇到 0 右移，遇到非 0 与 left 指向的元素交换
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int len = nums.length, left = 0, right = 0;
            while (right < len) {
                if (nums[right] != 0) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                }
                right++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

