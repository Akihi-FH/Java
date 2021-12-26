package sword.one.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 最小的k个数
 */
class GetMinimumKNumbers {
    /**
     * sort方法排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || arr.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 快排
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        int[] res = new int[k];
        quick(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quick(int[] nums, int l, int r, int k) {
        if (l < r) {
            int idx = randomPartition(nums, l, r);
            int num = idx - l + 1;
            if (k == num) {
                return;
            } else if (k < num) {
                quick(nums, l, idx - 1, k);
            } else {
                quick(nums, idx + 1, r, k - num);
            }
        }
    }

    // 数组中随机选取一个基准值
    public int randomPartition(int[] nums, int l, int r) {
        int idx = l + new Random().nextInt(r - l + 1);
        // 基准值交换到最后
        swap(nums, idx, r);
        // 重排数组，获取基准值的最终位置
        return partition(nums, l, r);
    }

    // 根据基准值，重排数组，获取基准值的最终位置
    public int partition(int[] nums, int l, int r) {
        // 基准值
        int val = nums[r];
        // 将小于等于基准值的数交换到前面
        int p = l; // 指针左边全为小于基准值的数
        for (int i = l; i < r; i++) {
            if (nums[i] <= val) {
                swap(nums, p, i);
                p++;
            }
        }
        // 基准值插入指针p指向的位置，这样左边全小于等于基准值，右边全都大于基准值
        swap(nums, p, r);
        return p;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        GetMinimumKNumbers solution = new GetMinimumKNumbers();
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        solution.quickSort(arr, 0, arr.length - 1);
        System.out.println("快排：" + Arrays.toString(arr));
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            // 基准值下标
            int kIdx = randomPartition(nums, l, r);
            quickSort(nums, l, kIdx - 1);
            quickSort(nums, kIdx + 1, r);
        }
    }
}

public class P40_GetMinimumKNumbers {
}
