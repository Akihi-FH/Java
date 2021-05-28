package org.fh.SwordToOffer;

/**
 * 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 求x的n次方，n为整数
 */
class IntegerPowerOfNum {
    /**
     * 1、快速幂 + 递归
     * 当 n 为负数时，可以先计算 x 的 -n 次方，再取倒数
     * x^64 <- (x^32)^2 <- ((x^16)^2)^2 <- ...
     * x^32 = (x^16)^2
     * x^16 = (x^8)^2
     * ...
     * x^77 <- (x^38)^2 * x <- ((x^19)^2)^2 * x ...;
     * x^38 = (x^19)^2;
     * x^19 = (x^9)^2 * x
     * ...
     * 设 y = n/2, 若n为偶数：则 x^n = (y^(n/2))^2, 若n为奇数：则 x^n = (y^(n/2))^2 * x
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 2、快速幂 + 迭代
     *
     * x^77 <- (x^38)^2 * x <- ((x^19)^2)^2 * x ...;
     * x^38 = (x^19)^2;
     * x^19 = (x^9)^2 * x
     * x^9 = (x^4)^2 * x
     *
     * x^38 -> x^77 中额外乘的 x 在 x^77中贡献了 x；
     * x^9 -> x^19 中额外乘的 x 在之后被平方了2次，因此 在 x^77中贡献了 x^(2^2) = x^4；
     * x^4 -> x^9 中额外乘的 x 在之后被平方了3次，因此 在 x^77中贡献了 x^(2^3) = x^8；
     * 最初的 x 在之后被平方了6次，因此在 x^77中贡献了 (x^2)^6 = x^64；
     * 把这些贡献相乘， x * x^4 * x^8 * x^64 = x^77，恰好对应77的二进制表示 0100 1101 中的 1
     */
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    private double quickMul2(double x, long N) {
        double res = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return res;
    }
}

public class P16_IntegerPowerOfNum {
}