package org.fh.sortalgorithm;

import leetcode.editor.cn.P215_KthLargestElementInAnArray;

import java.util.Arrays;

public class BuildMaxHeap {
    public static void main(String[] args) {
        BuildMaxHeap solution = new BuildMaxHeap();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        nums = new int[]{3,2,3,1,2,4,5,5,6};
//        nums = new int[]{1};
        solution.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public int sort(int[] nums) {
        int n = nums.length;
        // 构建 一次 大顶堆
        buildMaxheap(nums, n);
        // 大顶堆最大值（第一个）与最后一个值交换，然后 将前 n-1 个元素 进行构建
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            n--;
            // 从 索引 0 （第一个元素）开始构建新的大顶堆
            maxHeap(nums, 0, n);
        }
        return nums[0];
    }

    // 第一次构建 大顶堆
    public void buildMaxheap(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(nums, i, n);
        }
    }

    // 从索引 i 开始构建大顶堆
    public void maxHeap(int[] nums, int i, int n) {
        // 左孩子指针 右孩子指针 及 他们与父节点中的最大值指针
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            // 交换后可能子树的父节点不是最大值了，递归 构建 使得子树的父节点也比他自己的左右孩子大
            maxHeap(nums, largest, n);
        }
    }

    // 交换
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
