package sword.one.array;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
class MissingNumber {
    /**
     * 二分法
     * 索引 i 只会小于等于 该处的值
     * i == val，缺少的数字在右边
     * i < val，缺少的数字在左边
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1 ;
            }
        }
        return left;
    }


    /**
     * for循环遍历
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}

public class P53_2_MissingNumber {
}
