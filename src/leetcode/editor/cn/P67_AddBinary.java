//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 593 👎 0

package leetcode.editor.cn;
public class P67_AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67_AddBinary().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1, j = b.length() - 1;
            int val = 0;
            StringBuilder res = new StringBuilder();
            while (i >= 0 || j >= 0 || val > 0) {
                int val1 = i >= 0 ? a.charAt(i) - '0' : 0;
                int val2 = j >= 0 ? b.charAt(j) - '0' : 0;
                int num = val1 + val2 + val;
                int ones = num % 2;
                val = num / 2;
                res.append(ones);
                i--;
                j--;
            }
            return res.reverse().toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

