package sword.one.array;

/**
 * 连续子数组的最大和；
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
class MaxSubArray {

    /**
     * if num[i-1] < 0 : 则 num[i-1] + num[i] < num[i] ,当前最大连续子序和为 num[i]
     * if num[i-1] >= 0 : 则 num[i-1] + num[i] >= num[i] ,当前最大连续子序和为 num[i-1] + num[i]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int tmp = 0;
        for (int num : nums) {
            // 当前数 与 当前数+之前最大和  之间大的数为当前为止的最大和
            tmp = Math.max(num, num + tmp);
            max = Math.max(tmp, max);
        }
        return max;
    }
}

public class P42_MaxSubArray {
}
