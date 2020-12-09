//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1031 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return list;
            }
            Map<Character, String> map = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(list, map, digits, 0, new StringBuilder());
            return list;
        }

        /**
         * 回溯
         * @param list 组合结果集合
         * @param map 数字-字母 映射表
         * @param digits 输入的数字字符串
         * @param index 字符串digits的索引
         * @param s 临时结果，保存本次字母组合
         */
        public void backtrack(List<String> list, Map<Character, String> map, String digits, int index, StringBuilder s) {
            // 本次索引遍历至digits长度后，即得到了一个字母组合
            if (index == digits.length()) {
                list.add(s.toString());
            } else {
                char digit = digits.charAt(index);
                // 获取本数字映射的所有字母
                String letters = map.get(digit);
                int length = letters.length();
                // 遍历本数字的所有字母
                for (int i = 0; i < length; i++) {
                    // 添加本数字的一个字母到临时结果里面
                    s.append(letters.charAt(i));
                    // 得到本数字映射的一个字母后，获取下一个数字映射的一个字母
                    backtrack(list, map, digits, index + 1, s);
                    // 字母组合保存到list后，清空 临时结果 - 本次字母组合
                    s.deleteCharAt(index);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

