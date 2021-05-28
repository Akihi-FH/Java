package org.fh.SwordToOffer;

public class P58_2_ReverseLeftWords {
}

class ReverseLeftWords {
    /**
     * 1、substring拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 2、StringBuilder遍历拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        /*
        // 可以用取余来简化以下代码
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        */
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}