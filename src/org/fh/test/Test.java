package org.fh.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test {


    public static void main(String[] args) {

    }

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

}