package sword.one.array;

/**
 * 元素可重复的排序数组中找一个数出现几次，
 */
class SearchNumInSortArray {
    public int search(int[] nums, int target) {
        return binary(nums, target) - binary(nums, target - 1);
    }

    // 找一个数的右边界
    private int binary(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 这里return l 或 r都是可以的，return l表示返回的是这个重复数的下一个数，return r表示返回的是这个重复数的最后一个
        return l;
    }
}

public class P53_1_SearchNumInSortArray {
}
