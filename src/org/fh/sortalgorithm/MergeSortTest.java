package org.fh.sortalgorithm;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        // 临时数组
        int[] tmp = new int[arr.length];
        // 开始归并
        mergeSort(arr, 0, arr.length - 1, tmp);
        System.out.println("归并排序：" + Arrays.toString(arr));
    }

    // 递归实现层层归并
    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, tmp); // 左边归并排序，使得左子序列有序
            mergeSort(arr, mid + 1, right, tmp);  // 右边归并排序，使得右子序列有序
            mergeBranch(arr, left, mid, right, tmp); // 将两个有序子数组合并操作
        }
    }
    // 合并两个子数组到临时数组中，再复制给原数组
    public static void mergeBranch(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left; //左指针
        int j = mid + 1; // 右指针
        int t = 0; // 合并指针
        // 合并数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            tmp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            tmp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = tmp[t++];
        }
    }
}
