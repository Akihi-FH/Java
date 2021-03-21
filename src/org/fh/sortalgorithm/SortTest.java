package org.fh.sortalgorithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 冒泡排序
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        bubbleSort(arr);
        System.out.println("冒泡：" + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("快排：" + Arrays.toString(arr));

        arr = new int[]{7, 4, 1, 3, 2, 6};
        quickSortByStack(arr);
        System.out.println("非递归快排：" + Arrays.toString(arr));

        maxHeapSort(arr);
        System.out.println("大堆排序：" + Arrays.toString(arr));

        insertSort(arr);
        System.out.println("插入：" + Arrays.toString(arr));

        selectSort(arr);
        System.out.println("选择：" + Arrays.toString(arr));

        shellSort(arr);
        System.out.println("希尔：" + Arrays.toString(arr));
    }

    /**
     * 快排 - 交换排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
        // l到r 排完序
        if (l >= r) {
            return;
        }
        // 取基准值
        int k = arr[l];
        int i = l, j = r;
        while (i < j) {
            // 从后向前找到小于基准的元素,找到就交换到前面
            while (i < j && k <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            // 从前向后找到大于基准的元素,找到就交换到后面
            while (i < j && arr[i] <= k) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = k; //放置基准值，准备分治递归
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    /**
     * 快排 - 非递归
     *
     * @param arr
     */
    public static void quickSortByStack(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int r = stack.pop();
            int l = stack.pop();

            // 经过一趟排序后，前后两个索引指向同一中间量
            int kIndex = partition(arr, l, r);

            if (kIndex > l) {
                stack.push(l);
                stack.push(kIndex - 1);
            }
            // kIndex < 0 表示某个部分排序完成了，就不需要继续进行快排了
            if (kIndex < r && kIndex >= 0) {
                stack.push(kIndex + 1);
                stack.push(r);
            }
        }
    }

    public static int partition(int[] arr, int l, int r) {
        if (l >= r) {
            return -1;
        }
        int i = l, j = r;
        // 基准值
        int k = arr[i];
        while (i < j) {
            // 从后向前找到小于基准的元素,找到就交换到前面
            while (i < j && k <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            // 从前向后找到大于基准的元素,找到就交换到后面
            while (i < j && k >= arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        //放置基准值
        arr[j] = k;
        return i; // 经过一趟排序后，前后两个索引指向同一中间量
    }


    /**
     * 大堆排序
     * @param arr
     */
    public static void maxHeapSort(int[] arr) {
        // 构建大顶堆，取出堆顶元素（数组第一个元素），然后将堆顶元素与最后一个元素交换，索引-1，
        // 下次构建堆不将最后一个元素包括在内
        for (int i = arr.length - 1; i > 0; i--) {
            // 构建大顶堆
            max_heapify(arr, i);
            // 取出堆顶元素
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
    public static void max_heapify(int[] arr, int n) {
        int child;
        // 第一个非叶子节点索引 i = (n-1) / 2, n为数组最大下标
        for (int i = (n - 1) / 2; i >= 0; i--) {
            // i 的左子节点索引 为 2i+1，右子节点索引为 2i+2
            child = 2 * i + 1; // 左子节点
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
     * 简单选择排序 - 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    /**
     * 简单插入排序 - 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 要插入的数
            int num = arr[i];
            int j;
            // 从已排序数的右边开始，若数 > num，则数右移
            for (j = i; j > 0 && num < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        // 确定步长
        for (int step = length / 2; step > 0; step = step / 2) {
            // 从 i 之后的每个数字进行 插入排序；就是插入的序列是步长所连接的不同序列
            for (int i = step; i < length; i++) {
                int tmp = arr[i];
                int j;
                for (j = i - step; j >= 0 && arr[j] > tmp; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = tmp;
            }
        }
    }
    /*public static void shellSort(int[] arr) {
        int length = arr.length;
        int h = 1;
        // 步长选择
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        // 当 步长 >= 1 时，计算新的步长
        for (; h >= 1; h = h / 3) {
            // 从 i 之后的每个数字进行 插入排序；就是插入的序列是步长所连接的不同序列
            for (int i = 0; i < arr.length - h; i += h) {
                //
                for (int j = i + h; j > 0; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
        }
    }*/


    /**
     * 冒泡排序 - 交换排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // 第一层循环 控制比较几轮；每一轮找出一个最大值
        for (int i = 0; i < arr.length - 1; i++) {
            // 第二层循环 控制一轮比较几次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
