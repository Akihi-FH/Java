//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1108 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39_CombinationSum().new Solution();
        int[] nums = new int[]{2,3,6,7};
        System.out.println(solution.combinationSum(nums, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            backtrack(list, candidates, target, 0, new ArrayList<>());
            return list;
        }

        /**
         * 回溯法
         *
         * @param list       数字组合的集合
         * @param candidates 数组
         * @param target     目标和
         * @param index      数组中当前索引
         * @param tempList   中间结果，某个数字组合
         */
        public void backtrack(List<List<Integer>> list, int[] candidates,
                              int target, int index, List<Integer> tempList) {
            // 每次从数组最后一个元素开始选取
            if (index == candidates.length) {
                return;
            }
            // 当target=0，说明找到一个组合，保存到list中
            if (target == 0) {
                list.add(new ArrayList<>(tempList));
                return;
            }
            // 先选取下一个元素
            backtrack(list, candidates, target, index + 1, tempList);
            // 差值 >=0，继续递进层次，从数组最后一个元素开始选取
            if (target - candidates[index] >= 0) {
                tempList.add(candidates[index]);
                // 用差值继续回溯，再次从数组最后一个元素开始选取
                backtrack(list, candidates, target - candidates[index], index, tempList);
                // 回到本层时，从组合中删除改元素；因为如果有组合符合条件，在回到这之前就会保存到list里面
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

