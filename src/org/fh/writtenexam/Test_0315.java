package org.fh.writtenexam;


import java.util.Scanner;

public class Test_0315 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            getNum(a, b, c);
        }
    }

    /**
     * 输入a,b,c三个数，每次可以任意将a或b中的一个二进制位调换；
     * 最少调换几次能使得a|b=c
     *
     * @param a
     * @param b
     * @param c
     */
    public static void getNum(int a, int b, int c) {
        int num = 0; // 调换次数
        // 每次针对最低位进行比较，如果a、b、c都为 0，说明相等了
        while (a != 0 || b != 0 || c != 0) {
            // 如果c的最低位是 1，
            if ((c & 1) == 1) {
                // 如果 a和b的最后一位都为0，那么需要调换一次。
                if ((a & 1) == 0 && (b & 1) == 0) {
                    num++;
                }
            } else { // 如果c的最低位是 0
                // 如果 a和b 最低位都是 1，调换两次；其中一个最低位是 1，调换一次
                if ((a & 1) == 1 && (b & 1) == 1) {
                    num += 2;
                } else if ((a & 1) == 1 || (b & 1) == 1) {
                    num++;
                }
            }
            // a,b,c 分别右移一位
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        System.out.println(num);
    }
}

/*
public static void run(int n) {
        double sum = 0;
        for (int i = 1; i < n; i++) {
            if (n - 2 * i >= 2 || 2 * i - n >= 2) {
                sum += i;
                int m = Math.abs(n - 2 * i);
                for (int j = 1; j < m; j++) {
                    sum += Math.abs(m - 2 * j);
                }
            } else {
                sum += n - i;
            }
        }
        System.out.println(sum / (n-1));
    }
    public static void run2(int n) {
        double sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n - 2 * i >= 2 ) {
                if (n % 2 == 0 && i == n/2) {
                    sum += i / 2.0;
                }else {
                    sum += i;
                }
                int m = n - 2 * i;
                for (int j = 1; j <= m/2; j++) {
                    int x = m - j;
                    sum += x;
                }
            } else {
                sum += n - i;
            }
        }
        System.out.println(sum / (n/2));
    }


*/