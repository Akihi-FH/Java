package org.fh.writtenexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * n组数，每组m个数，编号 1- m，每组抽一个数，使和等于k，问多少种取法
 */
public class Test_0317 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            getRes(n, m, k);
            list.add(count);
            count = 0;
        }
        for (int a : list) {
            System.out.println(a);
        }
    }

    public static void getRes(int n, int m, int k) {
        if (k == 0 && n==0) {
            count = (count++)%1000000007;
        } else if (n != 0) {
            for (int j = 1; j <= m; j++) {
                getRes(n - 1, m, k - j);
            }
        }
    }
}


