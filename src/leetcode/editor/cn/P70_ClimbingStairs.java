//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1341 👎 0

package leetcode.editor.cn;

public class P70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70_ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         * 设爬n阶有f(n)种方法，则f(n) = f(n-1) + f(n-2)
         * 实际上是一个斐波那契数列
         * 此处 r = p + q;
         * p：爬 n-2 阶楼梯有 p 种方法
         * q：爬 n-1 阶楼梯有 p 种方法
         * r：爬 n   阶楼梯有 r 种方法
         *
         * @param n
         * @return
         */
//        public int climbStairs(int n) {
//            // f(0)=1; f(1)=1; f(2)=2; ...
//            int p = 0, q = 0, r = 1;
//            for (int i = 1; i <= n; i++) {
//                p = q;
//                q = r;
//                r = p+q;
//            }
//            return r;
//        }

        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        /**
         * 递归 可求，但是超时
         * @param n
         * @return
         */
       /* public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return climbStairs(n - 1) + climbStairs(n - 1);
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}

