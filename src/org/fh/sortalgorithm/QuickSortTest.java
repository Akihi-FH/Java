package org.fh.sortalgorithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快排：" + Arrays.toString(arr));

        arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        quickByStack(arr);
        System.out.println("非递归-快排：" + Arrays.toString(arr));

    }

    /**
     * 快排 - 递归实现
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
        // 表示 l到r 排完序
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        // 取基准值
        int k = arr[i];
        while (i < j) {
            // 从后向前找到小于基准的元素,找到就交换到前面；等于号防止因为相同的数i和j一直不变，陷入上面while死循环
            while (i < j && k <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            // 从前向后找到大于基准的元素,找到就交换到后面；等于号防止因为相同的数i和j一直不变，陷入上面while死循环
            while (i < j && k >= arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        //放置基准值，准备分治递归
        arr[i] = k;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }


    /**
     * 非递归
     */
    public static void quickByStack(int[] arr) {
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
        // 表示 l到r 排完序
        if (l >= r) {
            return -1;
        }
        int i = l, j = r;
        // 取基准值
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
        //放置基准值，准备分治递归；此时i，j相等
        arr[i] = k;
        return i;
    }
}
