package org.fh.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 匹配有效的括号
 * 有效：()[]{}   ([{}])  (){[]}
 * 无效：([)]
 */
public class Test02 {
    public static void main(String[] args) {

    }

    /**
     * 使用栈
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0 || len == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
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
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 使用map和栈
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != map.get(stack.pop())) {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}
