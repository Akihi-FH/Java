package sword.one.array;

/**
 * 力扣154，数组中有重复元素
 */
class MinNumOfRotateArray {

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                /**
                 * 由于重复元素的存在，我们并不能确定{numbers}[mid]究竟在最小值的左侧还是右侧。
                 * 唯一确定的是，[low,mid]或者[mid, high]中必有一个区间所有值相等。
                 * 执行 high--缩小判断范围。因为high
                 */
                high--;
            }
        }
        return numbers[low];
    }
}

public class P11_MinNumOfRotateArray {
    /**
     * 力扣153，数组中无重复元素
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
