package sword.one.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
class FindRepeatNumberInArray {
    /**
     * 交换
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                i++; // 索引和该处值相等时，才后移
                continue;
            }
            // 由于之前把数 n交换到了索引为 n的位置，所以若遇到重复的数时，满足该条件
            // num[i] = n , num[n] = n
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            // 还没遇到重复的数时，将 i 处的值 num[i] 交换到 索引num[i]处
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

public class P03_FindRepeatNumberInArray {
}
