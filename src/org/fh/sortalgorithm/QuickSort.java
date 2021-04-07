package org.fh.sortalgorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        solution.quickSort(arr, 0, arr.length - 1);
        System.out.println("快排：" + Arrays.toString(arr));
    }

    /**
     * 快速排序 - 标准版
     * @param nums
     * @param l
     * @param r
     */
    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            // 基准值下标
            int kIdx = randomPartition(nums, l, r);
            quickSort(nums, l, kIdx - 1);
            quickSort(nums, kIdx + 1, r);
        }
    }

    // 随机选取某个坐标的值作为基准值
    public int randomPartition(int[] nums, int l, int r) {
        // l到r中的随机下标处的值作为基准值
        int i = new Random().nextInt(r - l + 1) + l;
        // 把基准值交换到最后
        swap(nums, i, r);
        // 获取这个随机基准值的最终位置
        return partition(nums, l, r);
    }

    // 基准值最终下标位置
    public int partition(int[] nums, int l, int r) {
        // 基准值
        int kVal = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            // nums[j]小于基准值交换到前面，否则 i不变
            if (nums[j] <= kVal) {
                swap(nums, ++i, j);
            }
        }
        // 把最后面的基准值交换到最终位置 并返回
        swap(nums, i + 1, r);
        return i + 1;
    }
    // 交换
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
