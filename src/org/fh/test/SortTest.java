package org.fh.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
//        arr = new int[]{7, 4, 1, 3, 2, 6};

        sort(arr, 0, arr.length - 1);
        System.out.println("排序：" + Arrays.toString(arr));
    }


    public static void sort(int[] arr, int left, int right) {

    }
}
