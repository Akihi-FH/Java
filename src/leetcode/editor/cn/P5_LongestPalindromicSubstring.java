//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2947 👎 0

package leetcode.editor.cn;

public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 中心扩展
         *
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            // 记录当前最长回文子串的下标
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 1个字符扩展之后的长度
                int len1 = expandAroundCenter(s, i, i);
                // 2个字符扩展之后的长度
                int len2 = expandAroundCenter(s, i, i + 1);
                // 两种情况中的最大长度
                int len = Math.max(len1, len2);
                // 计算当前最长回文子串的起止下标; start和end都包含在内
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }
        // 在包含下标left和right的字符串基础上扩展，返回所能扩展的最大长度
        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }


        /**
         * 动态规划
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int length = s.length();
            String str = "";
            boolean[][] dp = new boolean[length][length];
            // 当前判断l+1个字符
            for (int l = 0; l < length; l++) {
                // 字符下标 i,j; 数组下标 [i][i + l]
                for (int i = 0; i + l < length; i++) {
                    int j = i + l;
                    // 只有一个字符时，数组对应下标位置为 true
                    if (l == 0) {
                        dp[i][j] = true;
                    } else if (l == 1) { // 两个字符时，需要判断两个字符是否相同
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    } else { // 其他
                        dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                    }
                    // 当前最长回文子串
                    if (dp[i][j] && l + 1 > str.length()) {
                        str = s.substring(i, j + 1);
                    }
                }
            }
            return str;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

