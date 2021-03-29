package org.fh.SwordToOffer;


import java.util.HashSet;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 */
class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 双指针
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
}

public class P48_LengthOfLongestSubstring {
}
