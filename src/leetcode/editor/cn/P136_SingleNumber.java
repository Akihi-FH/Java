//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1586 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P136_SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136_SingleNumber().new Solution();
        int[] nums = new int[]{4, 5, 6, 8, 8, 5, 6};
//        int[] nums = new int[]{4, 1, 2, 1, 2};
//        int[] nums = new int[]{2, 2, 1};
        System.out.println(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 位运算: 异或
         *  任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕ 0=a。
         *  任何数和其自身做异或运算，结果是 00，即 a⊕ a=0。
         *  异或运算满足交换律和结合律，即 a ⊕ b⊕ a = b ⊕ a ⊕ a = b ⊕ (a ⊕ a) = b ⊕ 0 = b
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int n : nums) {
                single ^= n;
            }
            return single;
        }

        /**
         * map保存换成list保存，相同移除
         * 使用了空间
         * @param nums
         * @return
         */
        /*public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if(map.containsKey(n)) {
                    map.remove(n);
                }else {
                    map.put(n, n);
                }
            }
            return map.keySet().iterator().next();
        }*/

        /**
         * 换成list保存，相同移除
         * 使用了空间
         *
         * @param nums
         * @return
         */
        /*public int singleNumber(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                if(list.contains(n)) {
                    list.remove(new Integer(n));
                }else {
                    list.add(n);
                }
            }
            return list.get(0);
        }*/

        /**
         * 两层for循环暴力破解
         *
         * @param nums
         * @return
         */
        /*public int singleNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] == nums[j] && i != j) {
                        break;
                    }
                    if (j == nums.length - 1) {
                        return nums[i];
                    }
                }
            }
            return -1;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

