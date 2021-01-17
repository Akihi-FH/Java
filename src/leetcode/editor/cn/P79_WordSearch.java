//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 744 👎 0

package leetcode.editor.cn;

public class P79_WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79_WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 回溯
         *
         * @param board
         * @param word
         * @return
         */
        public boolean exist(char[][] board, String word) {
            int rows = board.length, cols = board[0].length;
            // 对二维数组中每个点都作为起点来寻找word
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    boolean exist = backtrack(board, word, new boolean[rows][cols], i, j, 0);
                    if (exist) {
                        // 只要通过其中一个点找到了: true
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 回溯
         *
         * @param board   二维数组
         * @param word    单词字符串
         * @param visited 记录二维数组中已选过的位置
         * @param i       二维数组行的下标
         * @param j       二维数组列的下标
         * @param index   字符串索引下标
         * @return
         */
        public boolean backtrack(char[][] board, String word, boolean[][] visited,
                                 int i, int j, int index) {
            boolean exist = false;
            if (board[i][j] != word.charAt(index)) {
                return false;
            } else if (index == word.length() - 1) {
                return true;
            }
            visited[i][j] = true; // (i,j) 已选
            // 表示方向的二维数组：上、下、左、右等方向移动时的行列坐标变化
            int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            // 分别向上、下、左、右 四个方向选择
            for (int[] dir : directions) {
                // 新的i、j索引 newi 和 newj
                int newi = i + dir[0], newj = j + dir[1];
                // 如果 新的索引下标符合条件 且 (newi, newj)没有被选择过
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length
                        && !visited[newi][newj]) {
                    // 回溯，继续寻找word中的字符
                    exist = backtrack(board, word, visited, newi, newj, index + 1);
                    if (exist) {
                        // 如果找到了
                        break;
                    }
                }
            }
            visited[i][j] = false;
            return exist;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

