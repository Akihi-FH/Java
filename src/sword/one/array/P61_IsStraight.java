package sword.one.array;

import java.util.Arrays;

class IsStraight {
    /**
     * 排序 + 遍历
     * 1、 除了王，没有重复数
     * 2、 max - min < 5
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[count] < 5;
    }
}

public class P61_IsStraight {
}
