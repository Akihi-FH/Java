package org.fh.sortalgorithm;

import java.util.Arrays;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        shellSort(arr);
        System.out.println("希尔：" + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        // 确定步长
        for (int step = length / 2; step > 0; step /= 2) {
            // 从 i 之后的每个数字进行 插入排序；插入的序列是步长所连接的不同序列
            for (int i = step; i < length; i++) {
                // 保存步长末端值
                int num = arr[i];
                int j;
                // 步长连接的两端值进行比较，前 < 后，则插入排序的方式交换
                for (j = i - step; j >= 0 && arr[j] > num; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = num;
            }
        }
    }

}
