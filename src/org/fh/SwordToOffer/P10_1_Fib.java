package org.fh.SwordToOffer;

/**
 * 斐波那契数列
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
class Fib {
    /**
     * 设正整数 x, y, p，求余符号为 % ，则有 (x + y)  % p = (x % p + y % p) % p
     * 则 f(n)  % p = (f(n-1) % p + f(n-2) % p) % p
     * f(n) = ( f(n-1)  + f(n-2) )% p
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int x = 0, y = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (x + y) % 1000000007;
            x = y;
            y = sum;
        }
        // 这里 i=0 对应 f(2); 所以i = n-1 对应f(n+2), f(n-2) 对应 f(n) 即 x 为 f(n)
        return x;
    }
}

public class P10_1_Fib {
}
