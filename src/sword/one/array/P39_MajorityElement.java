package sword.one.array;

import java.util.Arrays;

/**
 * 多数元素
 */
class MajorityElement {
    /**
     * 投票
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }


    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

public class P39_MajorityElement {
}
