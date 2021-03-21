package org.fh.sortalgorithm;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        bubbleSort(arr);
        System.out.println("冒泡：" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        // 第一层循环 控制比较几轮；每一轮找出一个最大值
        for (int i = 0; i < arr.length - 1; i++) {
            // 第二层循环 控制一轮比较几次
            int n = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    n++;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (n==0){
                break;
            }
        }
    }
}
