//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 624 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49_GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 将排序后的字符串作为map的key，
         * 原字符串作为map的value的内容
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }

        /**
         * 计数
         * @param strs
         * @return
         */
        /*public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                // 字母表计数
                int[] counts = new int[26];
                int length = s.length();
                for (int i = 0; i < length; i++) {
                    counts[s.charAt(i) - 'a']++;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sb.append('a' + i);
                        sb.append(counts[i]);
                    }
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

