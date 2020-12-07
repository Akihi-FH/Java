package org.fh.practice.leetcode;

/**
 * 爬n阶楼梯到楼顶，每次可以爬 1 或者 2 阶，有多少种方法可以爬到楼顶
 */
public class Test05 {
    public static void main(String[] args) {
        int n = 3;
//        System.out.println(climbStairs(n));
        System.out.println(new Test05().climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs1(int n) {
        // f(0)=1; f(1)=1; f(2)=2; ...
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
