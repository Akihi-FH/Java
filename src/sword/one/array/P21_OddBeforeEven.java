package sword.one.array;

import java.util.Arrays;

class OddBeforeEven {
    public int[] exchange(int[] nums) {
        // 指针左边的都是奇数，pre指向最左边的偶数
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遍历，如果i处为奇数则与pre处进行交换，也就是将后面的奇数交换到前面来
            if (nums[i] % 2 != 0) {
                swap(nums, pre, i);
                pre++; // pre指向下一个偶数
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

public class P21_OddBeforeEven {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = new OddBeforeEven().exchange(nums);
        System.out.println(Arrays.toString(res));
    }
}
