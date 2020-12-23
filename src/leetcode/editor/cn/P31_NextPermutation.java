//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 881 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P31_NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31_NextPermutation().new Solution();
        System.out.println(Arrays.toString(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            int i = length - 2;
            // 从右往左找出一个满足 nums[i] < nums[i+1] 的索引 i
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            // 从右往左找出第一个大于 nums[i] 的值 num[j] 的索引 j
            if (i >= 0) {
                int j = length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                // 交换i 和 j 处的 值
                swap(nums, i, j);
            }
            // 将 i 后面的元素反转
            reverse(nums, i + 1);
        }

        // 交换 i 和 j 处的元素
        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // 从 left索引处开始翻转nums数组的元素
        public void reverse(int[] nums, int left) {
            int right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

