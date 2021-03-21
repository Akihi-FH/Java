package org.fh.SwordToOffer;

/**
 * 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 */
class NumTimesInArray {

    /**
     * 寻找target和target-1在数组中的右边界 然后相减
     */
    public int search(int[] nums, int target) {
        return find(nums, target) - find(nums, target - 1);
    }
    // 寻找target在数组中的右边界
    public int find(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 循环跳出时 l 指向右边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }



    /*
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 循环跳出时 l 指向右边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int right = l;
        // 数组中无 target
        if (r >= 0 && nums[r] != target) {
            return 0;
        }
        // 找到左边界 right
        l = 0;
        r = nums.length - 1;
        // 循环跳出时 r 指向左边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int left = r;
        return right - left - 1;
    }
    */
}

public class P53_1_NumTimesInArray {
}
