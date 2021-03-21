package org.fh.sortalgorithm;

import java.util.Arrays;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        insertSort(arr);
        System.out.println("插入：" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 要插入的数
            int num = arr[i];
            int j;
            // 从已排序数的右边开始，若已排序数 > num，则数右移
            for (j = i; j > 0 && num < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }
}
