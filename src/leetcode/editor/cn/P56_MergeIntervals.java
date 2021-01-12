//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 755 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56_MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][];
            }
            // 先按照左端点进行排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                int l = intervals[i][0], r = intervals[i][1];
                // 如果合并集合list为空，或 当前区间左端点 > 集合中 最大的右端点，则不合并直接添加
                if (list.size() == 0 || l > list.get(list.size() - 1)[1]) {
                    list.add(new int[]{l, r});
                } else { // 否则 将集合中最大的右端点值 更新为 其与当前区间右端点中的最大值
                    int r_tmp = list.get(list.size() - 1)[1];
                    list.get(list.size() - 1)[1] = Math.max(r_tmp, r);
                }
            }
            return list.toArray(new int[list.size()][]);
        }


        /* 最快答案
        public int[][] merge(int[][] intervals) {
            int mergeCount = 0,len = intervals.length;
            for(int i = 0;i < len - 1;i ++){
                for(int j = i + 1;j < len;j ++){
                    if(merge(intervals,i,j)){
                        mergeCount ++; //统计需要合并的次数
                        break; //如果进行了合并,需要停止此时循环，因为前一行变成了[1,-1]
                    }
                }
            }
            int index = 0;
            int[][] ans = new int[len - mergeCount][2]; //ans数组长度=原数组长度-合并次数
            for(int[] interval : intervals){
                if(interval[0] != 1 || interval[1] != -1){
                    ans[index++] = interval;
                }
            }
            return ans;
        }

        private boolean merge(int[][] intervals,int i,int j){
            int[] row1 = intervals[i]; //取第i行
            int[] row2 = intervals[j]; //取第i+1行
            if(row1[0] > row2[0]){ //比如[2,6]和[1,3],交换顺序(2 > 1)
                int[] temp = row1;
                row1 = row2;
                row2 = temp;
            }
            if(row1[1] < row2[0]){  //比如[8,10]和[15,18],此时不需要合并(10 < 15)
                return false; //表示没有进行合并
            }
            //不满足上述条件,比如[1,3]和[2,6] =>需要合并成[1,6]
            intervals[j][0] = row1[0];
            intervals[j][1] = Math.max(row1[1],row2[1]);
            intervals[i][0] = 1;
            intervals[i][1] = -1;  //此时由[1,3],[2,6] =>[1,-1],[1,6]
            return true; //表示进行了合并
        }
        */
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

