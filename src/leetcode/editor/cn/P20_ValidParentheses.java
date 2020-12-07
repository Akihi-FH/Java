//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1986 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 空字符串、字符串长度不为偶数：false
         * 遍历时当前字符为右括号，此时栈空或栈没有匹配的括号：false
         * 遍历完成之后，栈中还有数据：false
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if (s.length() == 0 || s.length() % 2 != 0) {
                return false;
            }

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                        stack.push(')');
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case '{':
                        stack.push('}');
                        break;
                    default:
                        if (stack.size() == 0 || c != stack.pop()) {
                            return false;
                        }
                        break;
                }
            }
            return stack.size() == 0;
        }

        /**
         * map + 栈
         * @param s
         * @return
         */
        /*public boolean isValid(String s) {
            int len = s.length();
            if(len%2!=0){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<Character, Character>(){{
                put('(',')');
                put('[',']');
                put('{','}');
            }};

            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)) {
                    stack.push(c);
                } else if(stack.isEmpty() || c != map.get(stack.pop())) {
                    return false;
                }
            }
            if(!stack.isEmpty()){
                return false;
            }
            return true;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}

