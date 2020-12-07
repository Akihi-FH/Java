//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2792 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序 + 双指针
         * a+b+c=0; --> -a = b+c
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            // 排序
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 这里加i>0，避免索引出界
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 取 第一个数的负数；-a = b+c
                int minus_first = -nums[i];
                // 第三个数的起始索引
                int k = n - 1;
                for (int j = i + 1; j < n; j++) {
                    // 这里加j>i+1，避免与第一个数的索引冲突
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // 第二个数的索引<第三个数的索引
                    while (j < k && nums[j] + nums[k] > minus_first) {
                        // 若 b + c > -a，第三个数左移，即变小
                        k--;
                    }
                    // 若第二个数的索引 == 第三个数的索引，退出本次对第二个数的循环
                    if (j == k) {
                        break;
                    }
                    if (nums[j] + nums[k] == minus_first) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
            return lists;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

