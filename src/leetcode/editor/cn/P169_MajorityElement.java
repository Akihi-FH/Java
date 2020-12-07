//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 799 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序后取中间位置元素
         *
         * @param nums
         * @return
         */
        /*public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }*/

        /**
         * 随机取出一个数判断是否是多数元素
         * @param rand
         * @param min
         * @param max
         * @return
         */
        /*private int randRange(Random rand, int min, int max) {
            return rand.nextInt(max - min) + min;
        }
        private int countOccurences(int[] nums, int num) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }
        public int majorityElement(int[] nums) {
            Random rand = new Random();
            int majorityCount = nums.length / 2;
            while (true) {
                int candidate = nums[randRange(rand, 0, nums.length)];
                if (countOccurences(nums, candidate) > majorityCount) {
                    return candidate;
                }
            }
        }*/

        /**
         * 投票法
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate= null;
            for (int num : nums) {
                if(count == 0) {
                    candidate = num;
                }
                count += candidate == num ? 1 : -1;
            }
            return candidate;
        }

        /**
         * stream api 统计每个数字的个数
         * 然后找出数字的个数大于数组长度一半的数字
         * @param nums
         * @return
         */
        /*public int majorityElement(int[] nums) {
            Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            long limit = nums.length >> 1;
            for (Map.Entry<Integer, Long> entry : map.entrySet())
                if (entry.getValue() > limit)
                    return entry.getKey();
            return -1;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

