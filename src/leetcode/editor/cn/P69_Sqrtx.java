//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 657 👎 0

package leetcode.editor.cn;

public class P69_Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69_Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分逼近法 寻找 mid² <= x 的最大mid值
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            // 这里考虑 x = 1的情况，r = x/2 后 + 1
            int l = 0, r = x / 2 + 1;
            int res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                long tmp = (long) mid * mid;
                if (tmp <= x) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

