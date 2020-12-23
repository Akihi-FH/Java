//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4631 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针，左指针为索引，右指针为right
         * 右指针右移，while:元素与集合中不重复且右指针索引小于length，
         *   则添加元素且右指针右移
         * 否则更新最大长度max
         * 左指针向右移动一格，若此时集合中还包含右指针指向的元素，左指针继续右移
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            // right 为右指针
            int max = 0, right = 0, len = s.length();
            Set<Character> set = new HashSet<>();
            // i 为左指针
            for (int i = 0; i < len; i++) {
                /*if (i != 0) {
                    set.remove(s.charAt(i-1));
                }*/
                // 右指针小于字符串长度 且 右指针元素与集合中元素不重复
                while (right < len && !set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    right++;
                }
                // 若不满足上述条件，
                max = Math.max(max, right - i);
                // 从集合中删除左指针的元素
                set.remove(s.charAt(i));
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

