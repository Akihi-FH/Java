package org.fh.SwordToOffer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 */
class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 双指针，滑动窗口思想
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int r = 0; // 右指针
        int max = 0;
        // i 左指针
        for (int i = 0; i < n; i++) {
            // 左指针右移（i++）后，即右指针遇到重复元素后，集合中删除上次左指针指向的元素，
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 左指针不动，右指针右移，元素不重复加入集合
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, r - i);
        }
        return max;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            // i: 元素上一次出现的位置
            int i = map.getOrDefault(s.charAt(j), -1);
            // 更新元素的最新位置
            map.put(s.charAt(j), j);
            // tmp：以位置j的前一个位置的元素结尾的最长不重复子串，
            // j-i：元素最新位置 减去 这个元素上一次出现的位置 i:
            // 若 tmp < j-i，则i不包含在tmp包含的长度里面，则以j处元素结尾的最长不重复子串长度为：tmp+1
            // 否则 i 在tmp所包含的长度里面，此时以j处元素结尾的最长不重复子串长度为：j-i
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}

public class P48_LengthOfLongestSubstring {
}
