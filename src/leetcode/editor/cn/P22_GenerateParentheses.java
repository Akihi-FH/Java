//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1477 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回溯法
         *  如果左括号数量不大于 n，我们可以放一个左括号。
         *  如果右括号数量小于左括号的数量，我们可以放一个右括号。
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            getAllByBackTrack(list, n, 0, 0, new StringBuilder());
            return list;
        }
        public void getAllByBackTrack(List<String> list, int n, int left, int right, StringBuilder sb) {
            if (n * 2 == sb.length()) {
                list.add(sb.toString());
            } else {
                if (left < n) {
                    sb.append("(");
                    getAllByBackTrack(list, n, left + 1, right, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (right < left) {
                    sb.append(")");
                    getAllByBackTrack(list, n, left, right + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        /**
         * 暴力破解
         * 生成所有序列，找出其中有效的括号序列；
         *
         * @param n
         * @return
         */
        /*public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            getAll(list, 0, new char[2 * n]);
            return list;
        }
        public void getAll(List<String> list, int index, char[] chars) {
            if (index == chars.length) {
                if (validate(chars)) {
                    list.add(new String(chars));
                }
            } else {
                chars[index] = '(';
                getAll(list, index + 1, chars);
                chars[index] = ')';
                getAll(list, index + 1, chars);
            }
        }
        public boolean validate(char[] chars) {
            int cnt = 0;
            for (char c : chars) {
                if ('(' == c) {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt < 0) {
                    return false;
                }
            }
            return cnt == 0;
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

