//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 503 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new P448_FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 遍历数组，把 |num[i]| - 1 索引处的元素乘以 -1 标记为负数，说明数组中存在数字 i+1
         * 再遍历一次数组，若 i 索引处的数字不为负数，说明数组中不存在数字 i+1
         *
         * @param nums
         * @return
         */
        /*public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] *= -1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }*/

        /**
         * 使用boolean数组标记arr[i] = true，即有 i+1 这个数字
         *
         * @param nums
         * @return
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                dp[nums[i]] = true;
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!dp[i]) {
                    result.add(i);
                }
            }
            return result;
        }


        /**
         * map存储后比较缺少哪些元素
         * @param nums
         * @return
         */
        /*public List<Integer> findDisappearedNumbers(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, 1);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                if (!map.containsKey(i)) {
                    list.add(i);
                }
            }
            return list;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

