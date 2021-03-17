package org.fh.SwordToOffer;

import java.util.Arrays;

// 数组中出现次数超过一半的元素
class MajorityElement {
    /**
     * 排序取中间元素
     *
     * @param nums
     * @return
     */
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/

    /**
     * 投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count = count + (num == candidate ? 1 : -1);
        }
        return candidate;
    }
}

public class P39_MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        new MajorityElement().majorityElement(arr);
    }
}
