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
                maxHeap(nums, 0, n);
            }
            return nums[0];
        }

        public void buildMaxheap(int[] nums, int n) {
            for (int i = n / 2; i >= 0; i--) {
                maxHeap(nums, i, n);
            }
        }

        public void maxHeap(int[] nums, int i, int n) {
            int l = 2 * i + 1, r = 2 * i + 2, largest = i;
            if (l < n && nums[l] > nums[largest]) {
                largest = l;
            }
            if (r < n && nums[r] > nums[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(nums, i, largest);
                maxHeap(nums, largest, n);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

