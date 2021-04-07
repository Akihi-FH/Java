package org.fh.writtenexam;

import java.util.ArrayList;
import java.util.List;

public class SumOfContinuousNums {

    public static void main(String[] args) {
        // [[2, 3, 4, 5, 6, 7], [8, 9, 10], [13, 14]]
        System.out.println(SumofContinuousNums(27));
    }

    // 给一个整数，求有哪些 连续的加数和 等于这个数
    public static List<List<Integer>> SumofContinuousNums(int num) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= num / 2 + 1; i++) {
            int sum = i;
            for (int j = i + 1; j <= num / 2 + 1; j++) {
                sum += j;
                if (sum == num) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        tmp.add(k);
                    }
                    list.add(tmp);
                    break;
                }
                if (sum > num) {
                    break;
                }
            }
        }
        return list;
    }
}
