package sword.one.array;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
class TwoSumOfSortArray {
    /**
     * 左右指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{nums[left], nums[right]};
            } else if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}

public class P57_TwoSumOfSortArray {
}
