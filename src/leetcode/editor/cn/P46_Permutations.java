//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1061 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P46_Permutations {
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
//            List<Integer> tempList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            backtrack(list, tempList, 0, nums.length);
            return list;
        }
        /**
         * 回溯
         * @param list 组合集合
         * @param tempList 某个组合
         * @param index 当前索引
         * @param length 数组长度
         */
        public void backtrack(List<List<Integer>> list, List<Integer> tempList, int index, int length) {
            if (index == length) {
                list.add(new ArrayList<>(tempList));
            }
            for (int i = index; i < length; i++) {
                // 交换元素
                Collections.swap(tempList, index, i);
                backtrack(list, tempList, index + 1, length);
                // 撤销交换
                Collections.swap(tempList, index, i);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

