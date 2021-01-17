//给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 947 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P78_Subsets {
    public static void main(String[] args) {
        Solution solution = new P78_Subsets().new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回溯
         * @param nums
         * @return
         */
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }


        /**
         * n个数的数组，有2的n次方个子集
         * @param nums
         * @return
         */
        /*
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            int n = nums.length;
            // 2的n次方 ==> 1<<n, bin表示n位二进制数的一种组合
            // 这里就是根据n个二进制数的2的n次方个不同组合，
            // i 从 0开始
            // 组合中从右到左若第 i个为1，就把num[i]添加到中间列表存储
            for (int bin = 0; bin < (1 << n); bin++) {
                List<Integer> tmpList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    // 判单3位的二进制数中的哪一位是 1
                    // (bin & (1 << i)) != 0 , 则 索引i处为 1
                    // 将nums[i]添加到中间list存储
                    if ((bin & (1 << i)) != 0) {
                        tmpList.add(nums[i]);
                    }
                }
                list.add(tmpList);
            }
            return list;
        }
        */
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

