package org.fh.writtenexam;

import java.math.BigInteger;
import java.util.Scanner;

public class MeiTuan_0911 {
    public static void main(String[] args) {

    }

    static void p1() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.length() < 2) {
            System.out.println(0);
            return;
        }
        int count = 0;
        int length = str.length();
        BigInteger rem = new BigInteger("22");
        for (int left = 0; left < length - 1; left++) {
            for (int right = left + 1; right < length; right++) {
                if (((int) (str.charAt(right - 1)) - '0') % 2 != 0) {
                    continue;
                }
                String numStr = str.substring(left, right);
                BigInteger num = new BigInteger(numStr);
                if (num.mod(rem).compareTo(BigInteger.ZERO) == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }




    /**
     * 5 5 3
     * 1 2
     * 2 3
     * 3 4
     * 4 5
     * 1 4
     * 2 5
     * 1 2
     * 3 4
     */
    static void p2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[] count = new int[n + 1];
        for (int i = 1; i < 2 * m + 1; i++) {
            int num = scanner.nextInt();
            count[num]++;
        }
        for (int i = 0; i < q; i++) {
            int swap1 = scanner.nextInt();
            int swap2 = scanner.nextInt();
            int tmp = count[swap1];
            count[swap1] = count[swap2];
            count[swap2] = tmp;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(count[i]);
        }
    }
}
