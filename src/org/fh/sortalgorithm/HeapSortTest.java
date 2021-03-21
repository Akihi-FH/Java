package org.fh.sortalgorithm;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        maxHeapSort(arr);
        System.out.println("大堆排序：" + Arrays.toString(arr));

        minHeapSort(arr);
        System.out.println("小堆排序：" + Arrays.toString(arr));

    }

    /**
     * 构建大顶堆形成升序排序，即结果为小顶堆
     *
     * @param arr
     */
    public static void maxHeapSort(int[] arr) {
        // 从最大下标开始循环构建大顶堆，只需要构建 数组长度-1 个堆，取出堆顶元素（数组第一个元素），然后将堆顶元素与最后一个元素交换，索引-1，
        // 下次构建堆不将最后一个元素包括在内
        for (int i = arr.length - 1; i > 0; i--) {
            // 构建大顶堆
            buildMaxHeap(arr, i);
            // 取出堆顶元素 与最后一个元素进行交换
            int heapTop = arr[0];
            arr[0] = arr[i];
            arr[i] = heapTop;
        }
    }
    /**
     * 构建大顶堆，首先找到第一个非叶子结点（从后往前），第一个非叶子节点索引 i = (n-1) / 2, n为数组最大下标
     * 对非叶子结点进行遍历 即每次 i--
     *      找到i的左子节点索引 child 。 i 的左子节点索引为 2i+1，右子节点索引为 2i+2；
     *      若child!=n,即右子节点存在，此时若 右子节点 > 左子节点 ，child索引指向右子节点
     *      将父节点与左右子节点中的较大值交换
     * @param arr
     * @param n
     */
    public static void buildMaxHeap(int[] arr, int n) {
        int child;
        // 第一个非叶子节点索引 i = (n-1) / 2, n为数组最大下标
        for (int i = (n - 1) / 2; i >= 0; i--) {
            // i 的左子节点索引 为 2i+1，右子节点索引为 2i+2
            child = 2 * i + 1;
            // 右子节点存在 且大于左子节点
            if (child != n && arr[child] < arr[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (arr[i] < arr[child]) {
                int temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
            }
        }
    }

    /**
     * 构建小顶堆形成降序排序，即结果为大顶堆
     * @param arr
     */
    public static void minHeapSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            buildMinHeap(arr, i);
            int heapTop = arr[0];
            arr[0] = arr[i];
            arr[i] = heapTop;
        }
    }
    public static void buildMinHeap(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            int child = 2 * i + 1;
            if (child != n && arr[child] > arr[child + 1]) {
                child++;
            }
            if (arr[i] > arr[child]) {
                int temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
            }
        }
    }
}
