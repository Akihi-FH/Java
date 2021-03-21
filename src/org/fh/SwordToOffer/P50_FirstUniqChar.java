package org.fh.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */

class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}

public class P50_FirstUniqChar {
}
