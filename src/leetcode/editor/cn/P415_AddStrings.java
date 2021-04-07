//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 348 👎 0

package leetcode.editor.cn;

public class P415_AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415_AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            // 从个位开始计算
            int i = num1.length() - 1, j = num2.length() - 1;
            int val = 0; // 进位
            while (i >= 0 || j >= 0 || val != 0) {
                int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int num = val1 + val2 + val;
                // 本位的数
                int ones = num % 10;
                // 进位
                val = num / 10;

                res.append(ones);
                i--;
                j--;
            }
            return res.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

