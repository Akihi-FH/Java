package org.fh.SwordToOffer;

// 二进制中1的个数
class HammingWeight {
    /**
     * n & n-1 会消掉最靠后的 1
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    /**
     * n & 1,若该位为 1， count加1，然后 n右移 1 位
     * @param n
     * @return
     */
    /*public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }*/

    /*public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }*/
}


public class P15_HammingWeight {
}
