package sword.one.others;

import java.util.Arrays;

/**
 * 反转单词顺序
 */
class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                res.append(strs[i] + " ");
            }
        }
        return res.toString().trim();
    }
}

public class P58_1_ReverseWords {
    public static void main(String[] args) {
//        System.out.println(new ReverseWords().reverseWords(""));

        String s = "  2  3 1";
        String[] strs = s.split(" ");
        System.out.println(Arrays.toString(strs));
    }
}
