package org.fh.SwordToOffer;

class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = strs.length-1 ; i >=0; i--) {
            if ("".equals(strs[i])) {
                continue;
            }
            str.append(strs[i]+" ");
        }
        return str.toString().trim();
    }
}


public class P58_1_ReverseWords {
}
