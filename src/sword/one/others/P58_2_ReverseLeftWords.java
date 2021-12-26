package sword.one.others;

class ReverseLeftWords {

    /**
     * 遍历 + 索引取余
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder res = new StringBuilder();
        // 取余操作有点骚
        for (int i = n; i < length + n; i++) {
            res.append(s.charAt(i % length));
        }
        return res.toString();
    }

    /**
     * 字符串拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

public class P58_2_ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 3));

        String s = "  123 ";
        s.trim();
    }
}
