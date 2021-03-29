package org.fh.writtenexam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// C4H9OH 计算值
public class Test_0327 {
    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('C', 12);
        put('H', 1);
        put('O', 16);
        put('N', 14);
    }};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1) {
                if (map.get(chars[i + 1]) == null) {
                    int ab = ab(chars, i + 1);
                    int a = 1;
                    int count = 0;
                    for (int j = ab; j >= i + 1; j--) {
                        count += (chars[j] - '0') * a;
                        a *= 10;
                    }
                    num += map.get(chars[i]) * count;
                    i = ab;
                } else {
                    num += map.get(chars[i]);
                }
            } else if (map.get(chars[i]) != null) {
                num += map.get(chars[i]);
            }
        }
        System.out.println(num);
    }

    static int ab(char[] chars, int i) {
        for (int j = i; j < chars.length; j++) {
            if (map.get(chars[j]) != null) {
                return j - 1;
            }
        }
        return chars.length - 1;
    }
}
