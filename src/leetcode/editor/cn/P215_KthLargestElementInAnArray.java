//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 970 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        nums = new int[]{3,2,3,1,2,4,5,5,6};
//        nums = new int[]{1};
        System.out.println(solution.findKthLargest(nums, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            buildMaxheap(nums, n);
            for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
                swap(nums, 0, i);
                n--;
                maxHeapify(nums, 0, n);
            }
            return nums[0];
        }

        public void buildMaxheap(int[] nums, int n) {
            for (int i = n / 2; i >= 0; i--) {
                maxHeapify(nums, i, n);
            }
        }

        public void maxHeapify(int[] nums, int i, int n) {
            int l = 2 * i + 1, r = 2 * i + 2, largest = i;
            if (l < n && nums[l] > nums[largest]) {
                largest = l;
            }
            if (r < n && nums[r] > nums[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(nums, i, largest);
                maxHeapify(nums, largest, n);
            }
        }



        /*
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSelect(int[] nums, int l, int r, int index) {
            // 基准的位置如果确定的话，所选的基准下标和 index相同 则找到了
            int q = randomPartition(nums, l, r);
            if (q == index) {
                return nums[q];
            } else { // 否则去左边或者右边的子数组中找
                return q < index ? quickSelect(nums, q + 1, r, index)
                        : quickSelect(nums, l, q - 1, index);
            }
        }

        // 在子数组中 随机选取基准值
        public int randomPartition(int[] nums, int l, int r) {
            // [l,r]中取出一个随机值作为基准值
            int i = random.nextInt(r - l + 1) + l;
            // 把 选定的基准值交换到子数组最后
            swap(nums, i, r);
            // 确定基准值的下标
            return partition(nums, l, r);
        }

        // 返回基准值的最终下标
        public int partition(int[] nums, int l, int r) {
            // x 是基准值；因为上一步已经将基准值交换到子数组最后一位了
            int x = nums[r], i = l - 1;
            // i 是用来把小于基准值的元素交换到前面
            // j 用来遍历子数组
            for (int j = l; j < r; j++) {
                // 小于基准值，交换i和j，
                // 遇到大于基准值的，先不移动，等下次遇到小于基准值的再交换
                if (nums[j] <= x) {
                    swap(nums, ++i, j);
                }
            }
            // 确定基准值的位置
            swap(nums, i + 1, r);
            return i + 1;
        }
        */

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

