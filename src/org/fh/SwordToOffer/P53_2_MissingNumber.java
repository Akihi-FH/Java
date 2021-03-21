package org.fh.SwordToOffer;

/**
 * ～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
class MissingNumber {
    /**
     * nums[m] == m,则 [l,m] 没有缺失, [m+1,r]缺失。
     * nums[m] != m,则 [m,r] 没有缺失, [l,m-1]缺失。
     * 跳出循环时，下标l表示的数字缺失
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}

public class P53_2_MissingNumber {
}
