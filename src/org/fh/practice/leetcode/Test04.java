package org.fh.practice.leetcode;

/**
 * 最大子序和
 * [-2,1,-3,4,-1,2,1,-5,4] --> [4,-1,2,1]  :6
 */
public class Test04 {


    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int max = nums[0], tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            max = Math.max(max, tmp);
        }
        return max;
    }
}
