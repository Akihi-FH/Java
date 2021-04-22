//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 449 👎 0

package leetcode.editor.cn;

public class P172_FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new P172_FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 看 n! 即 1*2*3...*(n-1)* n 中有多少个 5 相乘
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            int cnt = 0;
            while (n > 0) {
                cnt += n / 5;
                n /= 5;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

