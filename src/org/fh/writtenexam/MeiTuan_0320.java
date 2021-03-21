package org.fh.writtenexam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MeiTuan_0320 {
}



class Main {
    public static void main(String[] args) {
        new Main().t3();
    }

    void t4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][n];
        // 保存值日表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }


    void t3() {
        Scanner scanner = new Scanner(System.in);
        // n杯奶茶
        int n = scanner.nextInt();
        // m个人
        int m = scanner.nextInt();
        // C ml/s
        int C = scanner.nextInt();
        // 喝对应奶茶的时间数组
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int ml = scanner.nextInt();
            int time = ml / C;
            int r = ml % C;
            time = r > 0 ? time + 1 : time;
            list.add(time);
            sum += time;
        }
        list.sort((o1, o2) -> o2 - o1);
        int ave = sum / 3;
        int sumtime = 0;
        int tmp =0;
        for (int x : list){
            if (x+tmp>=3 && sumtime<x+tmp){
                sumtime=x+tmp;
                tmp =0;
            }else {
                tmp=x;
            }
        }
        System.out.println(sumtime);
    }

    void t2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            listA.add(num);
        }
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            listB.add(num);
        }
        listA.sort(Comparator.comparingInt(o -> o));
        listB.sort(Comparator.comparingInt(o -> o));
        int y = listA.get(0) - listB.get(0);
        int x = m - y;
        while (x < 0) {
            x = m + x;
        }
        System.out.println(x);
    }


    void t1() {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int i = 0;
        int num = 0;
        for (int j = 0; j < s1.length() && i < s2.length(); ) {
            if (s2.charAt(i) == s1.charAt(j)) {
                i++;
            }
            j++;
            num++;
            if (j == s1.length()) {
                j = 0;
            }
        }
        System.out.println(num - s2.length());

        /*Scanner scanner = new Scanner(System.in);
        char[] c1 = scanner.nextLine().toCharArray();
        char[] c2 = scanner.nextLine().toCharArray();
        int i = 0;
        int num = 0;
        for (int j = 0; j < c1.length && i < c2.length; ) {
            if (c2[i] == c1[j]) {
                i++;
            }
            j++;
            num++;
            if (j == c1.length) {
                j = 0;
            }
        }
        System.out.println(num - c2.length);*/
    }
}
