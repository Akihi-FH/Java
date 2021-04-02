//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 字符串 
// 👍 221 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P678_ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new P678_ValidParenthesisString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            // 存左括号下标
            Deque<Integer> stack = new LinkedList<>();
            // 存 * 号下标
            Deque<Integer> starStack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == '*') {
                    starStack.push(i);
                } else { // 遍历到元素为 右括号
                    // 两个栈都为空，false
                    if (stack.isEmpty() && starStack.isEmpty()) {
                        return false;
                    } else if (!stack.isEmpty()) { // stack不为空，左括号出栈
                        stack.pop();
                    } else { // starStack不为空，*出栈
                        starStack.pop();
                    }
                }
            }
            // 遍历完成 若 左括号数量 > *号数量，则 false
            if (stack.size() > starStack.size()) {
                return false;
            } else { // 若 左括号数量 < *号数量
                while (!stack.isEmpty() && !starStack.isEmpty()) {
                    // 如 * 号下标 < 左括号下标，不匹配 也是 false
                    if (stack.peek() > starStack.peek()) {
                        return false;
                    }
                    stack.pop();
                    starStack.pop();
                }
                return true;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

