//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意：请不要使用代码库中的排序函数来解决这道题。 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
// Related Topics 排序 数组 双指针 
// 👍 754 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P75_SortColors {
    public static void main(String[] args) {
        Solution solution = new P75_SortColors().new Solution();
        int[] nums;
//        nums = new int[]{1, 0};
        nums = new int[]{2, 1, 2};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 双指针
         * 两个指针分别用来交换 0和 1
         *
         * @param nums
         */
        public void sortColors(int[] nums) {
            int p0 = 0, p1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = tmp;
                    // 当p0<p1时，若num[i]=0,
                    // 此时交换必会将1交换到num[i]
                    // 就相当于遍历到 1了，再对 1进行交换
                    if (p0 < p1) {
                        tmp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = tmp;
                    }
                    p0++;
                    p1++;
                } else if (nums[i] == 1) {
                    int tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                    p1++;
                }
            }
        }



        /**
         * 双指针
         * 两个指针分别用来交换 0和 2
         *
         * @param nums
         */
        /*public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p2 = n - 1;
            for (int i = 0; i <= p2; i++) {
                // 因为可能交换后还是 2，相当于遍历到 2，再次交换
                // 交换后 若 i >p2，分类完成。不加索引限制可能会超出范围
                while (i <= p2 && nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = tmp;
                    p2--;
                }
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = tmp;
                    p0++;
                }
            }

        }*/



        /**
         * 单指针，循环两次
         *  指针ptr表示索引 0 到 ptr-1 处已经分好类
         *  索引ptr处等待颜色交换
         * 第一次循环：将颜色0与索引ptr处值交换
         * 第二次循环：将颜色1与索引ptr处值交换
         *
         * @param nums
         */
        /*
        public void sortColors(int[] nums) {
            int ptr = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0){
                    int tmp = nums[ptr];
                    nums[ptr] = nums[i];
                    nums[i] = tmp;
                    ptr++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==1){
                    int tmp = nums[ptr];
                    nums[ptr] = nums[i];
                    nums[i] = tmp;
                    ptr++;
                }
            }
        }
        */
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
