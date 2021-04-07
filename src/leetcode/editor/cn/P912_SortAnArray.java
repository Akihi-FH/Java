//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 259 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class P912_SortAnArray {
    public static void main(String[] args) {
        Solution solution = new P912_SortAnArray().new Solution();
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int l, int r) {
            if (l < r) {
                // 基准值下标
                int kIdx = randomPartition(nums, l, r);
                quickSort(nums, l, kIdx - 1);
                quickSort(nums, kIdx + 1, r);
            }
        }

        // 随机选取某个坐标的值作为基准值
        public int randomPartition(int[] nums, int l, int r) {
            // l到r中的随机下标处的值作为基准值
            int i = new Random().nextInt(r - l + 1) + l;
            // 把基准值交换到最后
            swap(nums, i, r);
            // 获取这个随机基准值的最终位置
            return partition(nums, l, r);
        }

        // 基准值最终下标位置
        public int partition(int[] nums, int l, int r) {
            // 基准值
            int kVal = nums[r];
            int i = l - 1;
            for (int j = l; j < r; j++) {
                // nums[j]小于基准值交换到前面，否则 i不变
                if (nums[j] <= kVal) {
                    swap(nums, ++i, j);
                }
            }
            // 把最后面的基准值交换到最终位置 并返回
            swap(nums, i + 1, r);
            return i + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

