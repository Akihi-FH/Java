package org.fh.SwordToOffer;

/**
 * 青蛙跳台阶
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
class ClimbingStairsNumWays {
    /**
     * 设正整数 x, y, p，求余符号为 % ，则有 (x + y)  % p = (x % p + y % p) % p
     * 则 f(n)  % p = (f(n-1) % p + f(n-2) % p) % p
     * f(n) = ( f(n-1)  + f(n-2) ) % p
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        int x = 1, y = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (x + y) % 1000000007;
            x = y;
            y = sum;
        }
        return x;
    }
}

public class P10_2_ClimbingStairsNumWays {
}
